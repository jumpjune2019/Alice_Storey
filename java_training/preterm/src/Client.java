// a client object

public class Client {
	private String lastname;
	private String firstname;
	private int id;
	private Seat seat;
	
	Client(String l, String f, int i) {
		lastname = l;
		firstname = f;
		id = i;
	}
	
	int getClientId() {
		return id;
	}
	
	String getClientLastName() {
		return lastname;
	}
	
	String getClientFirstName() {
		return firstname;
	}
	
	String getClientInitials() {
		char[] initialsArr = {' ', ' '};
		initialsArr[0] = firstname.charAt(0);
		initialsArr[1] = lastname.charAt(0); 
		return new String(initialsArr);
	}

	String getFullClientString() {
		String full = ("id: " + id + " lastname: " + lastname + " firstname: " + firstname);
		return full;
	}
	
	public String toString() {
		return getClientFirstName() + " " + getClientLastName();
	}
	
	public void setSeat(Seat seat) {
		this.seat = seat;
	}
	
	public Seat getSeat() {
		return this.seat;
	}
	
	public boolean isSeated() {
		return this.seat != null;
	}
}
