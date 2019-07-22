import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ButtonRoll implements ActionListener {
	JLabel jlab;
	String first;
	String second;
	String defaultmsg;
	boolean reset;
	
	public void setButtons(JPanel frm, String f, String s, String defaultmsg) {
		first = f;
		second = s;
		reset =true;
		JButton jbtnUp = new JButton(first);
		JButton jbtnDown = new JButton(second);
		// Add action listeners.
		jbtnUp.addActionListener(this);
		jbtnDown.addActionListener(this);
		// Add the buttons to the content pane.
		frm.add(jbtnUp,BorderLayout.CENTER);
		frm.add(jbtnDown,BorderLayout.SOUTH);
		// Create a label.
		jlab = new JLabel(defaultmsg);
		this.defaultmsg = defaultmsg;
		// Add the label to the frame.
		frm.add(jlab, BorderLayout.NORTH);
	}
	
	// Handle button events.
	private static int roll1d6() {
		int result = 0;
		double ran = Math.random();
		result = (int)(6*ran);
		result++;
		return result;
	}
	
	private void roll() {
		if(reset) {
			jlab.setText(String.format("Rolled: %d", roll1d6() ) );
			reset=false;
		}
	}
	
	private void reset() {
		jlab.setText(defaultmsg);
		reset=true;
	}

	public void actionPerformed(ActionEvent ae) {
		if(ae.getActionCommand().equals(this.first)) {			
			roll();			
		} 
		else {
			reset();
		}
	}
}
