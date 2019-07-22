import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class GridLayoutChallenge {
	
	private static int rows = 5, cols = 5;
	
	public static void centerAndSizeJFrameOnScreen(JFrame frm, int width, int height) {
		// set the size of the frame to half in width and height
		frm.setSize(width, height);
		// here's the part where the JFrame gets actually centered
		frm.setLocationRelativeTo(null);
	}
	
	public static void fixAlign(JLabel o) {
		o.setHorizontalAlignment(JLabel.CENTER);
		o.setVerticalAlignment(JLabel.CENTER);
	}
	
	public static JFrame setFrameStuff(JFrame frm, int onExit, int width, int height) {
		// this will center and size the JFrame on screen
		// it will have a height and width of half the screen
		centerAndSizeJFrameOnScreen(frm, width, height);
		frm.setDefaultCloseOperation(onExit);
		
		JPanel panel1 = new JPanel();
		
		panel1.setLayout(new BorderLayout());
		frm.setLayout(new BorderLayout());
		
		JLabel lbNorth = new JLabel("Basic Matrix Demo");
		fixAlign(lbNorth);
		panel1.add(lbNorth, BorderLayout.NORTH);
		
		/*
		JLabel lbCenter = new JLabel("Center");
		lbCenter.setHorizontalAlignment(JLabel.CENTER);
		lbCenter.setVerticalAlignment(JLabel.CENTER);
		panel1.add(lbCenter, BorderLayout.CENTER);
		*/
		
		JLabel lbSouth = new JLabel("No Seat Selected");
		fixAlign(lbSouth);
		panel1.add(lbSouth, BorderLayout.SOUTH);		
		
		
		
		JPanel gridPanel = new JPanel();
		gridPanel.setLayout(new GridLayout(rows,cols));
		gridPanel.setSize(rows*50, cols*50);
		
		JLabel[][] gridLabels = new JLabel[rows][cols];		
		JButton[][] gridButtons = new JButton[rows][cols];
		JPanel[][] gridBoxes = new JPanel[rows][cols];
		for (int r=0; r<rows; r++) {
			for (int c=0; c<cols; c++) {
				String label = String.format("%c-%d", (char)(r+65),c+1);
				
				gridBoxes[r][c] = new JPanel();
				JPanel box = gridBoxes[r][c];
				box.setLayout(new BoxLayout(box, BoxLayout.Y_AXIS));
				
				gridLabels[r][c] = new JLabel(label, JLabel.CENTER);
				JLabel jlabel = gridLabels[r][c];
				//fixAlign(jlabel);
				
				gridButtons[r][c] = new JButton(label);
				JButton button = gridButtons[r][c];
				button.setFont(new Font("Arial", Font.PLAIN, 8));
				
				//box.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
				//box.add(Box.createHorizontalGlue());
				box.add(jlabel, JLabel.CENTER);
				//box.add(Box.createHorizontalGlue());
				
				box.add(button);
				gridPanel.add(box);
			}
		}
		
		panel1.add(gridPanel, BorderLayout.CENTER);
		frm.add(panel1);
		return frm;
	}
	
	private static int ran2_5() {
		return (int) (Math.random()*4 + 2);
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
		rows = ran2_5();
		cols = ran2_5();
		
		SwingUtilities.invokeLater(new Runnable() {
			GLCFrame app;
			JFrame frm;
			
			
			
			public void run() {
				app = new GLCFrame("Grid Layout Challenge");
				frm = app.getFrame();
				frm = setFrameStuff(frm, JFrame.EXIT_ON_CLOSE, rows*50, cols*50 + 80);
				frm.setVisible(true);
			}
		});
	}
}