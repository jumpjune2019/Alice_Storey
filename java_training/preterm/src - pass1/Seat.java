
public class Seat {
	enum Row {
		A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z
	}
	
	private Client client;
	private boolean assignable;
	private Row r;
	private int c;
	
	Seat() {
		set('A', 0);
		this.assignable = true;
	}
	
	public Seat(int r, int c) {
		set(r,c);
		this.assignable = true;
	}
	
	public Seat(char r, int c) {
		set(r,c);
		this.assignable = true;
	}
	
	public void set(int r, int c) {
		this.r = Row.values()[r];
		this.c = c;
	}
	
	public void set(char r, int c) {
		this.r = Row.valueOf(Character.toString(r));
		this.c = c;
	}
	
	public static int rowNum(char r) {
		return Row.valueOf(Character.toString(r)).ordinal();
	}
	
	public static char rowChar(int r) {
		return r<Row.values().length ? Row.values()[r].name().charAt(0) : '-';
	}
	
	public int[] coords() {
		int[] rowcol =  { r.ordinal(), c };
		return rowcol;
	}
	
	public int getRow () {
		return coords()[0];
	}
	
	public int getCol() {
		return coords()[1];
	}
	
	public boolean canBeAssigned() {
		return assignable;
	}
	
	public void setCanBeAssigned(boolean assignable) {
		this.assignable = assignable;
	}
	
	public void setClient(Client client) {
		this.client = client;
		client.setSeat(this);
	}
	
	public Client getClient() {
		return this.client;
	}
	
	public boolean isAssigned() {
		return this.client != null;
	}
	
	public String getClientInitials() {
		return isAssigned() ? this.client.getClientInitials() : "";
	}
	
	public int getClientId() {
		return isAssigned() ? this.client.getClientId() : -1;
	}
	
	public String seatName() {
		return String.format("%s%d", r.name(), c);
	}
	
	public String toString() {
		return isAssigned() ? String.format("id: %d/%s", getClientId(), getClientInitials()) : (canBeAssigned() ? "vacant" : "X");
	}
}
