import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ComboBoxControl implements ActionListener{
	private JComboBox box;
	private String defaultmsg = "Selected ";
	private JLabel label;
	private JPanel panel;

	public ComboBoxControl(String[] items, JLabel label) {
		box = new JComboBox(items);
		this.label = label;
		box.setSize(250, 70);
		box.addActionListener(this);
		
		panel = new JPanel();
		panel.setSize(150, 70);
		panel.add(box);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JComboBox source = (JComboBox) e.getSource();
		String name = (String) source.getSelectedItem();
		System.out.println(name);
		label.setText(defaultmsg + name);
		
	}
	
	public void addTo(JFrame frame) {
		frame.add(panel);
	}
}
