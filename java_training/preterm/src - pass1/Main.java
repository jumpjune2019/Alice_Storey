public class Main {
	private static Room room;
	private static ClientStore myStore;

	public static void startApp() {
		System.out.println("startApp()");
		System.out.println("\n");
		
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
		ClientStore shuffledStore;
		try {
			shuffledStore = (ClientStore) myStore.clone();
			
		}
		catch (CloneNotSupportedException e) {
			throw e;
		}
		shuffledStore.shuffle();
		room = new Room(5,5);
		
		/*
		System.out.println("- DataCount: " + myStore.getClientDataCount());
		System.out.println("\nThis is a list of all the data in the store\n");
		*/
		
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
		System.out.println(room);
		System.out.println(myStore);
		
		
	}	
	
	public static void main(String[] args) throws CloneNotSupportedException {
		startApp();
		try {
			getInput();
		}
		catch (CloneNotSupportedException e) {
			System.out.println(e);
		}
	}

}
