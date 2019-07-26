import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Cell {
	private JPanel panel;
	private JLabel label;
	private JButton button;
	
	public Cell(int index) {
		panel = new JPanel();
		label = new JLabel(String.format("Label %d", index));
		button = new JButton(String.format("Button %d", index));
		
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(button);
		//panel.add(label);
	}
	
	public void addTo(JFrame frame) {
		frame.add(panel);
	}
	
	public void addTo(JPanel panel) {
		panel.add(this.panel);
	}


}
