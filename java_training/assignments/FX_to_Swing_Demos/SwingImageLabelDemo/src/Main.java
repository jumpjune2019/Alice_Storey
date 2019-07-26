
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class Main {
	private static final String TITLE = "Fungi is hilarious!";
	
	public static void centerAndSizeJFrameOnScreen (JFrame frm, int width, int height) {
	   	frm.setSize(width, height);
		frm.setLocationRelativeTo(null);
	}
	
	public static JFrame setupFrame(JFrame frm, int onExit) {
		// this will center and size the JFrame on screen
		// it will have a height and width of half the screen
		centerAndSizeJFrameOnScreen(frm, 100, 100);
		frm.setDefaultCloseOperation(onExit);

       		
		JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout());
	
		
		ImageIcon icon= new ImageIcon("fungi.png");
		Image image = icon.getImage();
		
		Image newimg = image.getScaledInstance(20, 20,  java.awt.Image.SCALE_SMOOTH);
		icon = new ImageIcon(newimg); 

		
		JLabel picLabel = new JLabel("Fungi");
		picLabel.setHorizontalTextPosition(SwingConstants.LEFT);
		
		picLabel.setIcon(icon);
	
		
		frm.add(picLabel);
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