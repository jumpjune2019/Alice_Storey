import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

public class SeatPanel implements ActionListener {
	private Seat seat;
	private JPanel panel;
	private JLabel label;
	private JButton button;
	private ListControl clients;
	private final int FONTSIZE=14;
	private final String FONT="Arial";
	
	public SeatPanel(Seat seat, ListControl clients) {
		this.seat = seat;
		this.clients = clients;
		label = new JLabel(seat.toString(), JLabel.CENTER);
		label.setToolTipText("(available)");
		panel = new JPanel();
		//panel.setLayout(new GridLayout(2,1));
		panel.setLayout(new FlowLayout());
		
		button = new JButton();
		button.addActionListener(this);
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		//buttonPanel.setBorder(new EmptyBorder(0,0,0,0));
		//button.setMaximumSize(new Dimension(45,45));
		buttonPanel.setMinimumSize(new Dimension(40,40));
		buttonPanel.setPreferredSize(new Dimension(40,40));
		unbook();
		
		panel.add(label);
		buttonPanel.add(button);
		panel.add(buttonPanel);
		
		//panel.add(button);
		panel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
	}
	
	
	public void addTo(JPanel panel) {
		//panel.add(this.panel);
		panel.add(this.panel);
	}
	
	public void setIcon(String filename) {
		ImageIcon icon = new ImageIcon(filename);
		Image image = icon.getImage();
		Image newimg = image.getScaledInstance(32, 32, java.awt.Image.SCALE_SMOOTH);
		button.setIcon(new ImageIcon(newimg));
	}
	
	public void book () {
		if (!seat.isAssigned()) {
			seat.setClient(clients.popSelection());
		}
		label.setText(seat.toString());
		label.setToolTipText(seat.getClient().getClientFullName());
		label.setFont(new Font(FONT, Font.BOLD, FONTSIZE));
		//button.setText("Unbook");
		button.setToolTipText("Unbook");
		setIcon("seat.png");
		button.setBackground(Color.GRAY);
		button.setBorder(BorderFactory.createLoweredBevelBorder());
	}
	
	public void unbook () {
		if (seat.isAssigned()) {
			clients.append(seat.getClient());
			seat.getClient().setSeat(null);
			seat.empty();			
		}
		label.setText(seat.toString());
		label.setToolTipText("(available)");
		label.setFont(new Font(FONT, Font.ITALIC, FONTSIZE));
		
		//button.setText("Book");
		button.setToolTipText("Book");
		setIcon("seat_empty.png");
		
		
		button.setBackground(new Color(100, 232, 72));
		button.setBorder(BorderFactory.createRaisedBevelBorder());
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
