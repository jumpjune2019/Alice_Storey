import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JRootPane;


public class CharListener implements KeyListener {
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
    
    static CharListener listener = new CharListener();
	
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
}