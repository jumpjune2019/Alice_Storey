import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;

public class ButtonControl implements ActionListener {
	private SeatPanel[][] seatPanels;
	private JPanel panel;
	
	public ButtonControl(Room room, ListControl clients) {
		panel = new JPanel();
		int rows = room.getNumRows(),
				cols = room.getNumCols();
		
		panel.setLayout(new GridLayout(rows+1, cols+1, 0, 8) );
		panel.setSize(rows*60, cols*60);
//		panel.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
		panel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		//extra row and col for labels
		
		
		
		seatPanels = new SeatPanel[rows][cols];
		
		for (int r=0; r<=rows; r++) {			
			for (int c=0; c<=cols; c++) {
				
				if (r==0 && c==0) {
					panel.add(new JLabel(" ", JLabel.CENTER));
					
				}
				else if (r==0) {
					panel.add(new JLabel("Seat "+c, JLabel.CENTER));
				}
				else if (c==0) {
					panel.add(new JLabel("Row "+Seat.rowChar(r-1), JLabel.CENTER));
				}
				else {
					SeatPanel seatp = new SeatPanel(room.get(r-1, c-1), clients);
					seatPanels[r-1][c-1] = seatp;
					seatp.addTo(panel);
				}
			}
		}
	}
	
	public void addTo(JFrame frame, String pos) {
		frame.add(panel, pos);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void unbookAll() {
		for (SeatPanel[] row : seatPanels) {
			for (SeatPanel seatp : row) {
				seatp.unbook();
			}
		}
	}

}
