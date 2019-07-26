import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class TreeViewControl implements ActionListener {
	private JScrollPane panel;
	private JTree tree;
	DefaultMutableTreeNode root;
	
	public TreeViewControl(String rootname) {
		root = new DefaultMutableTreeNode(rootname);
		tree = new JTree(root);
		panel = new JScrollPane(tree);
		//panel.add(tree);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
	public DefaultMutableTreeNode addNode(String newNodeName) {
		return addNode(root, newNodeName);
	}
	public DefaultMutableTreeNode addNode(DefaultMutableTreeNode parent, String newNodeName) {
		DefaultMutableTreeNode newChild = new DefaultMutableTreeNode(newNodeName);
		
		parent.add(newChild);
		
		return newChild;
	}
	
	public void addTo(JFrame frame) {
		frame.add(panel);
	}

}
