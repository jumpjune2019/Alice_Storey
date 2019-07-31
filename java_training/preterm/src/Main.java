import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

public class Main {
	private static Room room;
	private static ClientStore myStore;
	private static int width = 1200;
	private static int height = 1000;
	private static ListControl listControl;
	private static ButtonControl buttonControl;
	private static final String TITLE="Seat Booking App Demo";
	
	public static void startApp() {
		System.out.println("startApp()");
		System.out.println("\n");
		
		SwingUtilities.invokeLater(new Runnable() {
			AssignmentFrame app;
			JFrame frame;			
			
			public void run() {
				app = new AssignmentFrame(TITLE);
				frame = app.getFrame();
				frame = setupFrame(frame, JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
		
	}
	
	public static JLabel setHeaderLabel(JFrame frame) {
		
		JLabel headerLabel = new JLabel(TITLE, JLabel.CENTER);
		headerLabel.setFont(new Font("Arial", Font.BOLD, 20));
		JPanel headerPanel = new JPanel();
		headerPanel.setSize(width, 30);
		headerPanel.add(headerLabel);
		frame.add(headerPanel, BorderLayout.NORTH);
		
		return headerLabel;
	}
	
	public static JFrame setupFrame(JFrame frame, int onExit) {
		centerAndSizeJFrameOnScreen(frame, width, height);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(onExit);
		
		setHeaderLabel(frame);
		
		listControl = new ListControl(width, height);
		listControl.populate(myStore);		
		listControl.sort();
		listControl.addTo(frame, BorderLayout.WEST);
		
		buttonControl = new ButtonControl(room, listControl);
		buttonControl.addTo(frame, BorderLayout.CENTER);
		
		LogButtons logButtons = new LogButtons(buttonControl, myStore);
		logButtons.addTo(frame, BorderLayout.SOUTH);
		
		return frame;
	}
	
	
	public static void centerAndSizeJFrameOnScreen(JFrame frm, int width, int height) {
		frm.setSize(width, height);
		frm.setLocationRelativeTo(null);
	}
	
	public static void getInput() throws CloneNotSupportedException {

		// quick test of the client data structure
		/*
		System.out.println("getInput()\n");
		System.out.println("- We are going to create a Client class that will hold data and return itself or some info about it");
		Client testClient = new Client("Gauthier", "Claude", 2);
		System.out.println("Lastname: " + testClient.getClientLastName() + " " + "Firstname: " + testClient.getClientFirstName() + " " + "ID: " + testClient.getClientId());
		System.out.println("\n\n");
		*/
		
		// quick test to see if we can load data from a CSV file
		// and at least get an accurate count of the rows loaded in
		//System.out.println("- Testing the ClientStore class\n");
		myStore = new ClientStore("clients_list.csv");
		room = new Room(10,10);
		
		
		//code below would randomly assign clients to seats for testing purposes / pass 1
		/*
		ClientStore shuffledStore;
		try {
			shuffledStore = (ClientStore) myStore.clone();
			
		}
		catch (CloneNotSupportedException e) {
			throw e;
		}
		shuffledStore.shuffle();
		
		
																
//																System.out.println("- DataCount: " + myStore.getClientDataCount());
//																System.out.println("\nThis is a list of all the data in the store\n");
																
																
																// iterate via the array of store.
		Client[] store = shuffledStore.getClientStore();
		for(int i=0; i<store.length; i++) {
			Client client = store[i];
			if(client != null) {
																//System.out.println(c.getFullClientString());
				int r = i/room.getNumRows();
				int c = i%room.getNumCols();
				System.out.printf("Assigning %d, %d to %s\n", r, c, client);
				room.assign(r, c, client);
			}
		}
		*/
		
		//System.out.println(room);
		//System.out.println(myStore);
		
		
	}	
	
	public static void main(String[] args) throws CloneNotSupportedException {
		
		try {
			getInput();			
		}
		catch (CloneNotSupportedException e) {
			System.out.println(e);
		}
		startApp();
		
	}

}
