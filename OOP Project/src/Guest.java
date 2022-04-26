
public class Guest{
	private int guestID;
	private String name;
	private String phoneNumber;
	private String email;
	//here
	private boolean checkedIn;
	private Room room;

	public Guest() {
		name = null;
		phoneNumber = null;
		email = null;
		guestID = 0;
	}
	
	public Guest(String name, String phoneNumber, String email, int guestID) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.guestID = guestID;
	}
	
	public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
	public String getphoneNumber() {
		return phoneNumber;
	}
	public void setphoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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