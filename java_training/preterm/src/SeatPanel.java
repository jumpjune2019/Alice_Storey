import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class SeatPanel implements ActionListener {
	private Seat seat;
	private JPanel panel;
	private JLabel label;
	private JButton button;
	private ListControl clients;
	
	public SeatPanel(Seat seat, ListControl clients) {
		this.seat = seat;
		this.clients = clients;
		label = new JLabel(seat.toString(), JLabel.CENTER);
		panel = new JPanel();
		panel.setLayout(new GridLayout(2,1));
		panel.add(label);
		
		button = new JButton("Book");
		button.addActionListener(this);
		
		panel.add(button);
		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
	
	
	public void addTo(JPanel panel) {
		//panel.add(this.panel);
		panel.add(this.panel);
	}
	
	public void book () {
		if (!seat.isAssigned()) {
			seat.setClient(clients.popSelection());
			button.setText("Unbook");
			label.setText(seat.toString());
		}
	}
	
	public void unbook () {
		if (seat.isAssigned()) {
			clients.append(seat.getClient());
			seat.empty();
			button.setText("Book");
			label.setText(seat.toString());
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//System.out.printf("%s pressed while %s selected.\n", seat.seatName(), clients.getSelection());
		if(seat.isAssigned()) {
			unbook();
		}
		else if (clients.getSelection() != null) {
			book();
		}
	}

}
