import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JRootPane;

public class ThreadControl {
	private static MyThread[] threads;
	
	
	
	ThreadControl(int numThreads) {
		threads = new MyThread[numThreads];
		for (int i=1; i<=numThreads; i++ ) {
			threads[i-1] = new MyThread(String.format("thread %d", i));
		}
		
	}
	
	class MyThread implements Runnable {
		Thread thrd;
		boolean suspended;
		boolean stopped;
		boolean exit;
		int count;
		MyThread(String name) {
			thrd = new Thread(this, name);
			suspended = false;
			stopped = false;
			count = 0;
			exit = false;
			thrd.start();
		}
		
		public String getName() {
			return thrd.getName();
		}
		
		public String toString() {
			return getName();
		}
		
		
		// Begin execution of new thread.
		public void run() {
			System.out.println(thrd.getName() + " starting.");
			try {
				while(!stopped) {
					Thread.sleep((int) (5000 * (-1 * thrd.getPriority() + 11)/10.0));
					String out = thrd.getName();
					String num = out.substring(out.length()-1);
					out = out.substring(0, out.length()-1);
					
					for (int i=0; i<Integer.parseInt(num); i++) {
						out += " "; 
					}
					
					out = out + num;
					System.out.printf("executing %s\t(%d)\n", out, count);
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
			System.out.println(thrd.getName() + " terminating.");
		}
		
		// Stop the thread.
		synchronized void mystop() {
			stopped = true;
			// The following ensures that a suspended thread can be stopped.
			suspended = false;
			notify();
			
		}
		// Suspend the thread.
		synchronized void mysuspend() {
			suspended = true;
			notify();
		}
		// Resume the thread.
		synchronized void myresume() {
			suspended = false;
			notify();
		}
		
		
		boolean isRunning() {
			return !suspended;
			
		}
		
		boolean isAlive() {
			return !stopped;
		}
		
		String getState() {
			if (suspended) {
				return "paused";
			}
			else {
				return "running";
			}
		}
		
		void setPriority(int p) {
			if (p >= 1 && p <= 10) {
				thrd.setPriority(p);
			}
		}
	}
	
	private static CharListener listener = new CharListener();
	
	
	public static class CharListener implements KeyListener {
		JFrame frame = new JFrame(); 
		char result = '0';
		
		CharListener() {
			super();
		}
		
	    @Override 
	    public void keyPressed(KeyEvent e) {  
	        synchronized (frame) {  
	            frame.setVisible(false);  
	            frame.dispose();  
	            frame.notify();  
	        } 
	        result = e.getKeyChar();
	    }  
	    @Override 
	    public void keyReleased(KeyEvent e) {  
	    }  
	    @Override 
	    public void keyTyped(KeyEvent e) {  
	    }  
	    
	    public void setFrame(JFrame frame) {
	    	this.frame = frame;
	    }
	    
	    public JFrame getFrame() {
	    	return this.frame;
	    }
	    
	    public char getChar() {
	    	return result;
	    }
	}
	
	public static char getCh() {  
         
		JFrame frame = new JFrame();
        synchronized (frame) {  
            frame.setUndecorated(true);  
            frame.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);  
            
            listener.setFrame(frame);
            frame.addKeyListener((KeyListener)listener);  
            frame.setVisible(true);  
            try {  
                frame.wait();  
            } catch (InterruptedException e1) {  
            }  
        } 
        KeyListener klistener = frame.getKeyListeners()[0];
        return ((CharListener)klistener).getChar();
        
	}

	public static void endAll() {
		for (MyThread thread : threads) {
			thread.mystop();
		}
	}
	
	public static void stopThread(int threadIndex) {
		threads[threadIndex - 1].mystop();
	}
	
	public static void startstop(int threadIndex) {
		MyThread thread = threads[threadIndex - 1];
		if (thread.isRunning()) {
			thread.mysuspend();
			System.out.printf("pausing %s\n", thread.getName());
		}
		else {
			thread.myresume();
			System.out.printf("resuming %s\n", thread.getName());
		}
	}
	
	public static boolean runningThreads() {
		boolean running = false;
		for (MyThread thread : threads) {
			if (thread.isRunning()) {
				running = true;
				break;
			}
		}
		return running;
	}
	
	public static boolean hasAliveThreads () {
		boolean alive = false;
		for (MyThread thread : threads) {
			if (thread.isAlive()) {
				alive = true;
				break;
			}
		}
		return alive;
	}
	public static void printThreads () {
		System.out.println("Available threads are");
		for (int i=0; i<threads.length; i++) {
			MyThread thread = threads[i];
			if (thread.isAlive()) {
				System.out.printf("%s: %s - Press Key %d to control\n", thread, thread.getState(), i+1);
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello Thread Control");
		
		ThreadControl threadControl = new ThreadControl(5);
				
		int selectedThread = 0;
		
		char input=' ';
		while(hasAliveThreads()) {
			input = getCh();
			//System.out.printf("got char! %c\n",input);
			int value = input;
			
			if (value >= 49  &&  value <= 53) {
				
				int num = input - 48;
				if (selectedThread == 0 || num != selectedThread) {
					System.out.printf("controlling %s\n", threads[num-1].getName());
					selectedThread = value-48;
				}
				else {
					startstop(num);
				}
			}
			else if (selectedThread > 0 && selectedThread <= 5) {
				switch (input) {
			
				case 's':
						System.out.printf("Permanently stopping the execution of %s\n", threads[selectedThread-1]);
						stopThread(selectedThread);
						printThreads();
						break;
				case 't':
					System.out.printf("Setting priority of %s to %d\n", threads[selectedThread-1], 10);
						threads[selectedThread-1].setPriority(10);
						break;
				case 'n':
					System.out.printf("Setting priority of %s to %d\n", threads[selectedThread-1], 5);
						threads[selectedThread-1].setPriority(5);
						break;
				case 'l':
					System.out.printf("Setting priority of %s to %d\n", threads[selectedThread-1], 1);
						threads[selectedThread-1].setPriority(1);
						break;
				case 'q':
					endAll();
					break;
				}
			}
		}
		System.out.println("Terminating app.");
		//endAll();
		
		
	}

}
