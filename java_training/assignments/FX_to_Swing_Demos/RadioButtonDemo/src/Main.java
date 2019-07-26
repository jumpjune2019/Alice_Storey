import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Toolkit;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Main {
	private static final String TITLE = "Radio Button Demo";
	private static final String[] LIST = {"Train", "Car", "Airplane"};
	
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
		
		
		JLabel lab1 = new JLabel("Radio Buttons", JLabel.CENTER);		
		JLabel eventLabel = new JLabel("Test1", JLabel.CENTER);	
		
		RadioButtonControl control = new RadioButtonControl(LIST, eventLabel);
		
		
		
		
		
		frame.add(lab1);
		control.addTo(frame);
		frame.add(eventLabel);
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
