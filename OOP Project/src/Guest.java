
public class Guest extends Person{
	private int guestID;

	public Guest() {
		super();
		guestID = 0;
	}
	
	public Guest(String name, String phoneNumber, String email, int guestID) {
		super(name, phoneNumber, email);
		this.guestID = guestID;
	}

	public int getGuestID() {
		return guestID;
	}

	public void setGuestID(int guestID) {
		this.guestID = guestID;
	}
}