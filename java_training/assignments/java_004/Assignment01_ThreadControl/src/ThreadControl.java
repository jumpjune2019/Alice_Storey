import java.io.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JRootPane;

public class ThreadControl {
	
	class MyThread implements Runnable {
		Thread thrd;
		boolean suspended;
		boolean stopped;
		MyThread(String name) {
			thrd = new Thread(this, name);
			suspended = false;
			stopped = false;
			thrd.start();
		}
		
		// Begin execution of new thread.
		public void run() {
			System.out.println(thrd.getName() + " starting.");
			try {
				for(int count=0; count < 10; count++) {
					Thread.sleep(400);
					System.out.println("In " + thrd.getName() + ", count is " + count);
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
		}
		// Resume the thread.
		synchronized void myresume() {
			suspended = false;
			notify();
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello Thread Control");
		char input=' ';
		while(input != 'q') {
			input = getCh();
			System.out.printf("got char! %c\n",input);
		}
		
		
		
	}

}
