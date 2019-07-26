import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ScrollPaneControl implements ActionListener {
	private JButton button;
	private JScrollPane scrollpane;
	private JPanel panel;
	private JTextArea textarea;
	
	
	public ScrollPaneControl(String text) {
		button = new JButton("Reset Scroll Pane to Top/Left");
		
		panel = new JPanel();
		panel.setMaximumSize(new Dimension(150,150));
		panel.setLayout(new BorderLayout());
		
		textarea = new JTextArea(text);
		textarea.setAutoscrolls(true);
		textarea.setHighlighter(null);
		textarea.setEditable(false);
				
		scrollpane = new JScrollPane(textarea);
		
		button.addActionListener(this);
		
		
		panel.add(scrollpane, BorderLayout.CENTER);
		panel.add(button, BorderLayout.SOUTH);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		scrollpane.getHorizontalScrollBar().setValue(0);
		scrollpane.getVerticalScrollBar().setValue(0);
	}
	
	public void addTo(JFrame frame) {
		frame.add(panel);
	}

}
