

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CheckBoxControl implements ItemListener {
	private JPanel panel;
	private static String eventDefault = "Clicked: ";
	private static String listDefault = "<none>";
	private JLabel eventLabel;
	private JLabel listLabel;
	private JCheckBox[] checks;
	
	public CheckBoxControl(String[] list, JLabel eventLabel, JLabel listLabel) {
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		this.listLabel = listLabel;
		this.eventLabel = eventLabel;
		eventLabel.setText(eventDefault);
		listLabel.setText(listDefault);
		
		checks = new JCheckBox[list.length];
		int count = 0;
		for (String item : list) {
			checks[count] = new JCheckBox(item);
			checks[count].addItemListener(this);
			panel.add(checks[count]);
			count++;
		}
	}

	public void itemStateChanged(ItemEvent e) {
		System.out.println("item changed");
		String currentList = "";
		for (JCheckBox check : checks) {
			if (check.isSelected()) {
				if (currentList.length() > 0) {
					currentList += ", ";
				}
				currentList += check.getText();
			}
		}
		
		
		listLabel.setText( (currentList.length()>0) ? currentList :  listDefault );
		
		eventLabel.setText(eventDefault + ((JCheckBox)e.getSource()).getText());
	}
	
	public void addTo(JFrame frame) {
		frame.add(panel);
	}

}
