import javax.swing.*;
public class MyLabel {
	private String position;

	MyLabel() {
		
	}
	
	interface SetLabelInLayout {
		void run(JFrame jF, JLabel jl);
	}
	
	public final SetLabelInLayout setLabelInLayout = (JFrame jF, JLabel jl) -> {
		jF.add(jl, position);
	};
	
	interface SetLabel {
		JLabel run(String l, String p, JFrame jf);
	}
	
	public final SetLabel setLabel = (String l, String p, JFrame jf) -> {
		position = p;
		JLabel lb = new JLabel(l);
		setLabelInLayout.run(jf, lb);
		return lb;
	};
	
	
}
