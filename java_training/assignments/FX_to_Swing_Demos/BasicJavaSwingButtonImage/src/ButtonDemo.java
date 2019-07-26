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
	String third;
	String firstMsg;
	String secondMsg;
	
	public void setButtons(JPanel frm, String f, String s, String t, String fMsg, String sMsg) {
		first = f;
		second = s;
		third = t;
		firstMsg = fMsg;
		secondMsg = sMsg;
		
		frm.setLayout(new BoxLayout(frm, BoxLayout.Y_AXIS));
		
		JLabel label = new JLabel("Push a Button");
		
		JButton jbtnUp = new JButton(first);
		JButton jbtnDown = new JButton(second);
		JButton jbtnReset = new JButton(third);
		
		ImageIcon icon= new ImageIcon("fungi.png");
		Image image = icon.getImage();
		
		Image newimg = image.getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH);
		icon = new ImageIcon(newimg); 
		
		ImageIcon icon2= new ImageIcon("dairy.png");
		Image image2 = icon2.getImage();
		
		Image newimg2 = image2.getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH);
		icon2 = new ImageIcon(newimg2); 
		
		jbtnUp.setIcon(icon);	
		jbtnUp.setHorizontalTextPosition(SwingConstants.LEFT);
		jbtnDown.setIcon(icon2);
	
		// Add action listeners.
		jbtnUp.addActionListener(this);
		jbtnDown.addActionListener(this);
		jbtnReset.addActionListener(this);
		
		jlab = new JLabel(" ");
		
		frm.add(label);
		frm.add(jbtnUp);
		frm.add(jbtnDown);
		//frm.add(button);
		frm.add(jlab);
		frm.add(jbtnReset);
		
	}
	
	// Handle button events.

	public void actionPerformed(ActionEvent ae) {
		if(ae.getActionCommand().equals(first)) {
			jlab.setText(firstMsg);
		} 
		if(ae.getActionCommand().equals(second)) {
			jlab.setText(secondMsg);
		} 
		
		if(ae.getActionCommand().equals(third)) {
			jlab.setText(" ");
		} 
		
	}
}
