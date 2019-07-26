import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class RadioButtonControl implements ActionListener {
	private JPanel panel;
	ButtonGroup bgroup;
	JRadioButton[] buttons;
	private JLabel label;
	
	public RadioButtonControl (String[] items, JLabel label) {
		this.label = label;
		label.setText("");
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		
		buttons = new JRadioButton[items.length];
		bgroup = new ButtonGroup();
		
		int count=0;
		for (String item : items) {
			buttons[count] = new JRadioButton(item);
			buttons[count].addActionListener(this);
			bgroup.add(buttons[count]);
			panel.add(buttons[count]);
			count++;
		}
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JRadioButton source = (JRadioButton) e.getSource();
		label.setText(source.getText());
	}

	public void addTo(JFrame frame) {
		frame.add(panel);
	}
}
