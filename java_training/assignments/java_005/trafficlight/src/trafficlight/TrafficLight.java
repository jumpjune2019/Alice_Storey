package trafficlight;


/**
 * @author Alice
 * @version 1.0
 * @since 2019-07-12
 */
public class TrafficLight implements Runnable{
	enum Light {GREEN, RED, YELLOW};
	
	private Thread thrd;
	private boolean suspended;
	private boolean stopped;
	private int count;
	private Light light;
	/**
	 * @param name Name to describe traffic light thread. Will be printed on execution.
	 */
	public TrafficLight(String name) {
		thrd = new Thread(this, name);
		suspended = false;
		stopped = false;
		count = 0;
		light = Light.GREEN;
		thrd.start();
	}
	
	/**
	 * @return Returns name of thread which was given in constructor.
	 */
	public String getName() {
		return thrd.getName();
	}
	
	/**
	 * @return name of thread assigned at initialization
	 */
	public String toString() {
		return getName();
	}
	
	
	/**
	 * {@summary Loops until mystop() is called. For each traffic light color, displays a message and waits a particular amount of time (green: 5s, yellow: 2s, red: 3s).}
	 */
	public void run() {
		System.out.printf("Traffic Light Simulator is a Go!\n");
		try {
			while(!stopped) {
				int sleepDuration = 0;
				String msg = "";
				switch (light) {
				case GREEN:
					sleepDuration = 5000;
					msg = "Green - Go!";
					light = Light.YELLOW;
					break;
				case YELLOW:
					sleepDuration = 2000;
					msg = "Yellow - Beware!";
					light = Light.RED;
					break;
				case RED:
					sleepDuration = 3000;
					msg = "Red - Stop!";
					light = Light.GREEN;
					break;
				}
				
				System.out.printf("%s is %s\n", thrd.getName(), msg);
				
				Thread.sleep(sleepDuration);
				count++;
				
				
				synchronized(this) {
					while(suspended) {
						//System.out.printf("%s suspended.\n", thrd.getName() );
						wait();
					}
					if(stopped) {
						break;
					}
				}
			}
		}
		catch(InterruptedException exc) {
			System.out.println(thrd.getName() + " interrupted.");
		}
		System.out.printf("Traffic Light Simulator is Done!\n");
	}
	
	// Stop the thread.
	/**
	 * {@summary Flags thread to end. Will terminate before switching to next color in sequence.}
	 */
	public synchronized void mystop() {
		stopped = true;
		// The following ensures that a suspended thread can be stopped.
		suspended = false;
		notify();
		
	}
	// Suspend the thread.
	/**
	 * {@summary Pauses thread temporarily.}
	 */
	public synchronized void mysuspend() {
		suspended = true;
		notify();
	}
	// Resume the thread.
	/**
	 * {@summary Resumes thread if paused.}
	 */
	public synchronized void myresume() {
		suspended = false;
		notify();
	}
	
	
	/**
	 * @return True if thread is not paused with mysuspend()
	 */
	public boolean isRunning() {
		return !suspended;
		
	}
	
	/**
	 * @return True if thread has not been terminated.
	 */
	public boolean isAlive() {
		return !stopped;
	}
	
	/**
	 * @return "paused" if suspended with mysuspend(), otherwise "running"
	 */
	public String getState() {
		if (suspended) {
			return "paused";
		}
		else {
			return "running";
		}
	}
	
	/**
	 * @param p priority to be set, where 1<=p<=10
	 */
	public void setPriority(int p) {
		if (p >= 1 && p <= 10) {
			thrd.setPriority(p);
		}
	}	
}
