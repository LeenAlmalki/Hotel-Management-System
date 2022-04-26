import java.util.ArrayList;

public class Booking {
	  private int booking_id;
	  private int checkInDateTime;
	  private int checkOutDateTime;
	  private String bookingType;
	  
	  int CONFIRMED = 0;
	  int RESERVED = 1;
	 
	  public Booking()
	  {
		  guest = new userinfo();
		  room = new ArrayList<>();
		  booking_id = -1;
		  bookingType = "Reserved";
	  }
	 
	  public int getBooking_id() {
	        return booking_id;
	    }

	    public void setBooking_id(int booking_id) {
	        this.booking_id = booking_id;
	    }
	    
	    public String getBookingType() {
	        return bookingType;
	    }

	    public void setBookingType(String bookingType) {
	        this.bookingType = bookingType;
	    }
	    public void addRoom(String roomNo)
	    {
	        rooms.add(new Room(roomNo));
	        
	    }
	    
	    public void removeRoom(String roomNo)
	    {
	        for(Room a: rooms)
	        {
	            if(a.getRoom_no().equals(roomNo))
	            {
	                rooms.remove(a);
	            }
	        }
	    }


		public int getCheckOutDateTime() {
			return checkOutDateTime;
		}

		public void setCheckOutDateTime(int checkOutDateTime) {
			this.checkOutDateTime = checkOutDateTime;
		}

		public int getCheckInDateTime() {
			return checkInDateTime;
		}

		public void setCheckInDateTime(int checkInDateTime) {
			this.checkInDateTime = checkInDateTime;
		}

	

	    
}