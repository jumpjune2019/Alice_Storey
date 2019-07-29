import java.awt.BorderLayout;

import javax.swing.JFrame;

public class AssignmentFrame {
	private JFrame jfrm;
	AssignmentFrame(String title) {
		jfrm = new JFrame(title);
		jfrm.setLayout(new BorderLayout());
	}
	public JFrame getFrame() {
		return jfrm;
	}
}
