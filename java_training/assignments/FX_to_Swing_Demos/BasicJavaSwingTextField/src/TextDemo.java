
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class TextDemo implements ActionListener {
	JTextField jtf;
	JButton jbtnRev;
	JLabel jlabPrompt, jlabContents;

	TextDemo() {
		// Create a new JFrame container.
		JFrame jfrm = new JFrame("Use a Text Field");
		// Specify FlowLayout for the layout manager.
		jfrm.setLayout(new FlowLayout());
		// Give the frame an initial size.
		jfrm.setSize(240, 120);
		// Terminate the program when the user closes the application.
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Create a text field.
		jtf = new JTextField(10);
		// Set the action commands for the text field.
		jtf.setActionCommand("myTF");
		// Create the Reverse button.
		JButton jbtnRev = new JButton("Get Search String");
		// Add action listeners.
		jtf.addActionListener(this);
		jbtnRev.addActionListener(this);
		// Create the labels.
		jlabPrompt = new JLabel("Enter text: ");
		jlabContents = new JLabel("");
		// Add the components to the content pane.
		jfrm.add(jlabPrompt);
		jfrm.add(jtf);
		jfrm.add(jbtnRev);
		jfrm.add(jlabContents);
		// Display the frame.
		jfrm.setVisible(true);
	}
	// Handle action events.
	public void actionPerformed(ActionEvent ae) {
		String action = ae.getActionCommand();
		switch(action) {

			case "Get Search String":
				String orgStr = jtf.getText();
				jlabContents.setText("Search String: \n" + jtf.getText());
				
				
			break;
			
			case "myTF":
				String t = jtf.getText();
				if(t.isEmpty() || t.isBlank()) {
					jlabContents.setText("Shooting blank here buddy!");	
				} else {
					jlabContents.setText("Search String: " + jtf.getText());
				}
				
			break;
			
			default:
				// will never hit this portion of the code in this demo
				System.out.println("Duh?");
			break;
		}
	}

	public static void main(String args[]) {
	// Create the frame on the event dispatching thread.
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new TextDemo();
			}
		});
	}
}
