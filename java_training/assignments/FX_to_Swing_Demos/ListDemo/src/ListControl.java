import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ListControl implements ActionListener, ListSelectionListener {
	private static JList<String> jlist;
	private static DefaultListModel<String> listmodel;
	private static JScrollPane scrollPane;
	private JButton addButton;
	private JButton remButton;
	JLabel label;
	private String msgNoselect;
	private String msgSelect;
	
	public ListControl(String[] items, JLabel label, JButton addButton, JButton remButton) {
		this.label = label;
		this.addButton = addButton;
		this.remButton = remButton;
		
		msgNoselect = "Nothing Clicked.";
		msgSelect = "Transport selected is ";
		
		
		listmodel = new DefaultListModel<String>();
		jlist = new JList<String>(listmodel);
		scrollPane = new JScrollPane(jlist);
		scrollPane.setSize( 80, 200);
		
		populate(items);
		
		addButton.addActionListener(this);
		remButton.addActionListener(this);
		jlist.addListSelectionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == addButton) { 
			listmodel.addElement("Test");
		}
		else if (e.getSource() == remButton) {
			listmodel.remove(0);
		}
		setSelection();
	}
	
	private void setSelection() {
		String selection = jlist.getSelectedValue();
		if (selection == null) {
			label.setText(msgNoselect);
		}
		else {
			label.setText( msgSelect + selection  );
		}
	}
	
	public void valueChanged(ListSelectionEvent e) { 
		
		setSelection();
	}
	
	public void populate(String[] items) {		
		
		for (String item : items) {
			listmodel.addElement(item);
		}		
	}
	
	public void addTo(JFrame frame) {
		frame.add(scrollPane);
	}

}
