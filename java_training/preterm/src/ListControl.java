import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ListControl implements ListSelectionListener {
	private static JList<Client> jlist;
	private static DefaultListModel<Client> listmodel;
	private static JScrollPane scrollPane;
	
	public ListControl(int width, int height) {
		listmodel = new DefaultListModel<Client>();
		jlist = new JList<Client>(listmodel);
		scrollPane = new JScrollPane(jlist);
		scrollPane.setSize( width/3, height-60 );
		jlist.addListSelectionListener(this);
	}

	
	public void populate(ClientStore store) {
		Client[] clientarr = store.getClientStore();
		
		for (Client client : clientarr) {
			listmodel.addElement(client);
		}
		
	}
	
	public void addTo(JFrame frame, String pos) {
		frame.add(scrollPane, pos);
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		//System.out.println(jlist.getSelectedValue());
	}
	
	public Client getSelection() {
		return jlist.getSelectedValue();
	}
	
	public Client popSelection() {
		Client selection = getSelection();
		listmodel.removeElement(selection);
		return selection;
	}
	
	public void append(Client client) {
		listmodel.addElement(client);
	}

}
