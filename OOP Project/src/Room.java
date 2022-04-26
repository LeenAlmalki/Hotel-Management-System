public class Room {
// Room number 
	private int roomNo;	
	//Room Type (AC / Non-AC)
	private String roomType;
	//Bed Type (Single- Double- Triple)
	private String bedType;
	
	  public Room(int roomNo)
	    {
	        this.roomNo = roomNo;
	    }

	public String getBedType() {
		return bedType;
	}

	public void setBedType(String bedType) {
		this.bedType = bedType;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}
}
