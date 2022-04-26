import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.DropMode;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Guest extends JFrame {
	private JTextField txtGfdhd;

	//start
	private int guestID;
	private String name;
	private String phoneNumber;
	private String email;
	//here
	private boolean checkedIn;
	private Room room;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Guest frame = new Guest();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Guest() {
		setTitle("Guest");
		getContentPane().setBackground(new Color(238, 238, 238));
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Guest ID ");
		lblNewLabel.setBounds(14, 92, 66, 33);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Enter");
		btnNewButton.setBounds(138, 224, 147, 25);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		getContentPane().add(btnNewButton);
		
		txtGfdhd = new JTextField();
		txtGfdhd.setBounds(94, 92, 137, 33);
		getContentPane().add(txtGfdhd);
		txtGfdhd.setColumns(4);
	}

	
	//start
	
	
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
