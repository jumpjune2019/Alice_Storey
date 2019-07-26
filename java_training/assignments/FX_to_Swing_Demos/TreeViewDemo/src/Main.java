import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Toolkit;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;

public class Main {
	private static final String TITLE = "Tree View Demo";
	
	private static final String[] APPLES = {"Fuji", "Winesap", "Clark"},
			VEGETABLES = {"Corn", "Peas", "Broccoli", "Beans"},
			NUTS = {"Walnuts", "Almonds", "Pistachios", "Cashews"},
			FRUITS = {"Apples", "Pears", "Oranges"};
	
	/*
	 * Fruits
	 * >APPLES
	 * >>...
	 * >Pears
	 * >Oranges
	 * 
	 * VEGETABLES
	 * >...
	 * 
	 * NUTS
	 * >...
	 */
	
	
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
		
		
		JLabel lab1 = new JLabel("Tree View Demo", JLabel.CENTER);	
		
		TreeViewControl control = new TreeViewControl("Food");
		
		DefaultMutableTreeNode fruits = control.addNode("Fruits");
		for (String item : FRUITS) {
			DefaultMutableTreeNode fruitNode = control.addNode(fruits, item);
			if (item.equals("Apples")) {
				for (String apple : APPLES) {
					control.addNode(fruitNode,apple);
				}
			}
		}
		DefaultMutableTreeNode vegetables = control.addNode("Vegetables");
		for (String item : VEGETABLES) {
			control.addNode(vegetables, item);
		}
		DefaultMutableTreeNode nuts = control.addNode("Nuts");
		for (String item : NUTS) {
			control.addNode(nuts, item);
		}
		
		
		
		
		
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
