import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ButtonDemo  implements ActionListener {
	JLabel jlab;
	String first;
	String second;

	String firstMsg;
	String secondMsg;
	boolean toggle;
	
	public void setButtons(JPanel frm, String f, String s, String fMsg,String sMsg, boolean t) {
		first = f;
		second = s;
		toggle=t;
	
		firstMsg = fMsg;
		secondMsg = sMsg;

		
		frm.setLayout(new BoxLayout(frm, BoxLayout.Y_AXIS));
		
		JButton btn = new JButton(first);
		
		btn.addActionListener(this);
	
		JLabel jlab1= new JLabel("Push a Button");
		frm.add(jlab1);
		frm.add(btn);
		jlab = new JLabel("");
		frm.add(jlab);
	
	}
	
	// Handle button events.

	public void actionPerformed(ActionEvent ae) {
		
		if(toggle) {
			jlab.setText(firstMsg);
			toggle=false;
		}
		else {
			jlab.setText(secondMsg);
			toggle=true;
		}

			
  }
}
