import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.text.html.ImageView;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.*;

public class ButtonDemo  implements ActionListener {
	JLabel jlab;
	String first;
	String second;

	String firstMsg;
	String secondMsg;
	
	public void setButtons(JPanel frm, String f, String s, String fMsg, String sMsg) {
		first = f;
		second = s;
	
		firstMsg = fMsg;
		secondMsg = sMsg;
		
		frm.setLayout(new BoxLayout(frm, BoxLayout.Y_AXIS));
		
		JButton jbtnUp = new JButton(first);
		JButton jbtnDown = new JButton(second);
		

		jbtnUp.addActionListener(this);
		jbtnDown.addActionListener(this);
		
		
		jlab = new JLabel(" ");
	
		frm.add(jbtnUp);
		frm.add(jlab);
		frm.add(jbtnDown);

		
	}
	
	// Handle button events.

	public void actionPerformed(ActionEvent ae) {
		if(ae.getActionCommand().equals(first)) {
			jlab.setText(firstMsg);
		} 
		if(ae.getActionCommand().equals(second)) {
			jlab.setText(secondMsg);
		} 
			
	}
}
