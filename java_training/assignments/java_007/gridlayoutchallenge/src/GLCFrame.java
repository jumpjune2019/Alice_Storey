import javax.swing.JFrame;

public class GLCFrame {
	private JFrame jfrm;
	GLCFrame(String title) {
		// Create a new JFrame container.
		jfrm = new JFrame(title);
		//jfrm.setLayout(new BorderLayout(10,10));
	}
	public JFrame getFrame() {
		return jfrm;
	}
}
