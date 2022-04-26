
public class Guest extends Person{
	private int guestID;
	//here
	private boolean checkedIn;
	private Room room;

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
	
	//here 
	public boolean getStatus() {
	    return checkedIn;
	  }

	  public Room getRoom() {
	    return room;
	  }

	  public void setRoom(Room room) {
	    this.room = room;
	  }

	  public void setCheckedIn(boolean checkedIn) {
	    this.checkedIn = checkedIn;
	  }
	  
	//checkIN
	public void checkIn(Room room) {
	    if (this.getStatus() == false) {
	      this.setCheckedIn(true);
	      this.setRoom(room);
	    }
	  }
	
	//checkOUT
	public void checkOut() {
	    if (this.getStatus() == true) {
	      this.setCheckedIn(false);
	      this.setRoom(null);
	    }
	  }
	
	//payBill
	//the total price is called from the receptionist class
}