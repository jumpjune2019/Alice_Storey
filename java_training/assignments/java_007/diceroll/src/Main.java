import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.*;

public class Main {
	
		
	
	
	public static void centerAndSizeJFrameOnScreen(JFrame frm, int width, int height) {
		// set the size of the frame to half in width and height
		frm.setSize(width/2, height/2);
		// here's the part where the JFrame gets actually centered
		frm.setLocationRelativeTo(null);
	}
	
	public static JFrame setFrameStuff(JFrame frm, int onExit, int width, int height, ButtonRoll bd) {
		// this will center and size the JFrame on screen
		// it will have a height and width of half the screen
		centerAndSizeJFrameOnScreen(frm, width, height);
		frm.setDefaultCloseOperation(onExit);
		
		JPanel panel1 = new JPanel();
		
		panel1.setLayout(new BorderLayout());
		
		//bd = new ButtonFlip();
		bd.setButtons(panel1, "Click to Roll!", "Reset", "waiting...");
		
		frm.add(panel1);
		return frm;
	}
	
	

	public static void main(String[] args) {
		/*
		char input = ' ';	
		
		System.out.println(INIT);
		handleInput('f', FIRSTPASS);
		do {
		System.out.printf("%s %s!\n",RESULT,sideof.run(coinflip.run(0)));
		} while (handleInput('f', PROMPT));
		
		System.out.println(EXIT);
		*/
		ButtonRoll bd=new ButtonRoll();
		
		SwingUtilities.invokeLater(new Runnable() {
			DiceRollFrame app;
			JFrame frm;
			
			
			public void run() {
				app = new DiceRollFrame("Roll a Die");
				frm = app.getFrame();
				frm = setFrameStuff(frm, JFrame.EXIT_ON_CLOSE, 700, 250, bd);
				frm.setVisible(true);
			}
		});
		
		
	}
}
