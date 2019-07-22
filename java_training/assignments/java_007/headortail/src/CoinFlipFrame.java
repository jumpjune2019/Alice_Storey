import java.awt.BorderLayout;

import javax.swing.*;

public class CoinFlipFrame {
	private JFrame jfrm;
	CoinFlipFrame(String title) {
		// Create a new JFrame container.
		jfrm = new JFrame(title);
		//jfrm.setLayout(new BorderLayout(10,10));
	}
	public JFrame getFrame() {
		return jfrm;
	}
}
