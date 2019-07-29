import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LogButtons implements ActionListener {
	private JButton buttonReset;
	private JButton buttonLog;
	private JPanel panel;
	private ButtonControl buttonControl;
	private ListControl listControl;
	private ClientStore store;
	
	public LogButtons(ButtonControl buttonControl, ClientStore store) {
		panel = new JPanel();
		this.buttonControl = buttonControl;
		this.listControl = listControl;
		this.store = store;
		buttonReset = new JButton("Reset");
		buttonLog = new JButton("Print to Console");
		panel.add(buttonReset);
		panel.add(buttonLog);
		buttonReset.addActionListener(this);
		buttonLog.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == buttonReset) {
			buttonControl.unbookAll();
		}
		else {
			System.out.println(store.toString(true));
		}

	}
	
	public void addTo(JFrame frame, String pos) {
		frame.add(panel, pos);
	}

}
