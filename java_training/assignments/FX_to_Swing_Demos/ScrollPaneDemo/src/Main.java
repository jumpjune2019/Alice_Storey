import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Toolkit;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Main {
	private static final String TITLE = "ScrollPane Demo";
	private static final String TEXT = "A ScrollPane streamlines the process \n" + 
			" of adding darn scroll bars to a window whose contents \n" + 
			" exceed the viewing area dimension of the window \n " + 
			" It also enables a control to fit in \n " + 
			" Such as this label control in JavaFX \n " + 
			" Without it, we could not really view well the content \n " + 
			" of a control if it overflowed, so using scrollbars helps lots! \n";
	
	public static void centerAndSizeJFrameOnScreen (JFrame frm, int width, int height) {
	   	frm.setSize(width, height);
		frm.setLocationRelativeTo(null);
	}
	
	public static JFrame setupFrame(JFrame frame, int onExit) {
		// this will center and size the JFrame on screen
		// it will have a height and width of half the screen
		centerAndSizeJFrameOnScreen(frame, 300, 300);
		frame.setDefaultCloseOperation(onExit);
		frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		
		
		JLabel lab1 = new JLabel("ScrollPane Demo", JLabel.CENTER);	
		
		
		ScrollPaneControl control = new ScrollPaneControl(TEXT);
		
		
		
		
		frame.add(lab1);
		control.addTo(frame);
		return frame;
	}
	
	public static void startApp() {
		System.out.println("startApp()");
		System.out.println("\n");
		
		SwingUtilities.invokeLater(new Runnable() {
			
			JFrame frame;			
			
			public void run() {
				frame = new JFrame(TITLE);
				frame = setupFrame(frame, JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		startApp();
	}

}
