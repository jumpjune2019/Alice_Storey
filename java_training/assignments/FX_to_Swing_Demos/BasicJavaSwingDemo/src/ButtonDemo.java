
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


import java.awt.Image;
import java.awt.event.*;

public class ButtonDemo  implements ActionListener {
	JLabel jlab;
	String first;
	String second;
	String third;
	String firstMsg;
	String secondMsg;
	
	public void setButtons(JPanel frm, String f) {
		first = f;
		
		frm.setLayout(new BoxLayout(frm, BoxLayout.Y_AXIS));
		
		JButton jbtnUp = new JButton(first);
	

		jbtnUp.addActionListener(this);
		
		jlab = new JLabel(" ");
		
		
		frm.add(jbtnUp);
	
		
		frm.add(jlab);
		
		
	}
	
	// Handle button events.

	public void actionPerformed(ActionEvent ae) {
		if(ae.getActionCommand().equals(first)) {
			System.out.println("Hello World!");
		} 
	
	}
}