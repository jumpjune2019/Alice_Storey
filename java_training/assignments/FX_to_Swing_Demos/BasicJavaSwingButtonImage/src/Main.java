
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Main {
	private static final String TITLE = "Using Image with Buttons";
	
	public static void centerAndSizeJFrameOnScreen (JFrame frm, int width, int height) {
	   	frm.setSize(width, height);
		frm.setLocationRelativeTo(null);
	}
	
	public static JFrame setupFrame(JFrame frm, int onExit) {
		// this will center and size the JFrame on screen
		// it will have a height and width of half the screen
		centerAndSizeJFrameOnScreen(frm, 300, 300);
		frm.setDefaultCloseOperation(onExit);

       		
		JPanel panel2 = new JPanel();	
		panel2.setLayout(new FlowLayout());
	
		ButtonDemo bd2 = new ButtonDemo();
		bd2.setButtons(panel2, "Fungi", "Dairy","Reset", "fungi!", "dairy!");
			
		frm.add(panel2);
		return frm;	
		
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