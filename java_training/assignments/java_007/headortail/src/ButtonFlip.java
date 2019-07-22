import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.event.*;

public class ButtonFlip  implements ActionListener {
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
	
	private void flip() {
		if(reset) {
			jlab.setText(CoinFlip.sideof.run(CoinFlip.coinflip.run(0)));
			reset=false;
		}
	}
	
	private void reset() {
		jlab.setText(defaultmsg);
		reset=true;
	}

	public void actionPerformed(ActionEvent ae) {
		if(ae.getActionCommand().equals(this.first)) {			
			flip();			
		} 
		else {
			reset();
		}
	}
	
	void handleInput() {
		char input = ' ';
		while (true)
		{
			
			input = CharListener.getCh();
			switch(input) {
			case 'f':
				flip();
				break;
			case 'r':
				reset();
				break;
			}
		}
	}
}
