import java.awt.BorderLayout;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class CheckIn extends JFrame {

	private JPanel contentPane;
	
	// Text Fields 
	private JTextField nameTextField;
	private JTextField phoneTextField;
	private JTextField NIDTextField;
	private JTextField emailTextField;
	private JTextField checkInTextField;
	private JTextField priceTextField;
	
	//labels
	private JLabel label;
	private JLabel nameLabel;
	private JLabel phoneNumLabel;
	private JLabel NIDLabel;
	private JLabel emailLabel;
	private JLabel checkinLabel ;
	private JLabel bedLabel;
	private JLabel roomTypeLabel;
	private JLabel roomNumLabel;
	private JLabel priceLabel;
	
	//ComboBox
	JComboBox bedComboBox ;
	JComboBox roomTypeCombobox ;
	JComboBox roomNumCombobox ; 
	
	// Button
	JButton bookRoomButton;

	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckIn frame = new CheckIn();
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
	

	public CheckIn() {
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1145, 753);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		label = new JLabel("Customer Check IN");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.BOLD, 24));
		label.setBounds(45, 35, 270, 49);
		contentPane.add(label);
		
		JButton back = new JButton("back");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Home() .setVisible(true);
			}
		});
		back.setBounds(1005, 24, 85, 21);
		contentPane.add(back);
		
		nameLabel = new JLabel("Name");
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nameLabel.setBounds(45, 166, 100, 35);
		contentPane.add(nameLabel);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(206, 163, 270, 49);
		contentPane.add(nameTextField);
		nameTextField.setColumns(10);
		
		phoneNumLabel = new JLabel("Phone Number ");
		phoneNumLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		phoneNumLabel.setBounds(45, 259, 138, 35);
		contentPane.add(phoneNumLabel);
		
		phoneTextField = new JTextField();
		phoneTextField.setColumns(10);
		phoneTextField.setBounds(206, 256, 270, 49);
		contentPane.add(phoneTextField);
		
		NIDLabel = new JLabel("National ID");
		NIDLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		NIDLabel.setBounds(45, 359, 138, 35);
		contentPane.add(NIDLabel);
		
		NIDTextField = new JTextField();
		NIDTextField.setColumns(10);
		NIDTextField.setBounds(206, 356, 270, 49);
		contentPane.add(NIDTextField);
		
		emailLabel = new JLabel("Email");
		emailLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		emailLabel.setBounds(45, 458, 138, 35);
		contentPane.add(emailLabel);
		
		emailTextField = new JTextField();
		emailTextField.setColumns(10);
		emailTextField.setBounds(206, 455, 270, 49);
		contentPane.add(emailTextField);
		
		checkinLabel = new JLabel("Check in Date\r\n");
		checkinLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		checkinLabel.setBounds(45, 555, 138, 35);
		contentPane.add(checkinLabel);
		
		checkInTextField = new JTextField();
		checkInTextField.setColumns(10);
		checkInTextField.setBounds(206, 541, 270, 49);
		contentPane.add(checkInTextField);
		
		bedLabel = new JLabel("Bed");
		bedLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		bedLabel.setBounds(659, 166, 100, 35);
		contentPane.add(bedLabel);
		
		roomTypeLabel = new JLabel("Room Type");
		roomTypeLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		roomTypeLabel.setBounds(659, 259, 134, 35);
		contentPane.add(roomTypeLabel);
		
		bedComboBox = new JComboBox();
		bedComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// type
				roomDetails();
				
				
				
			}
		});
		bedComboBox.setFont(new Font("Tahoma", Font.PLAIN, 19));
		bedComboBox.setModel(new DefaultComboBoxModel(new String[] {"Select", "Single", "Double", "Triple"}));
		bedComboBox.setBounds(801, 166, 270, 35);
		contentPane.add(bedComboBox);
		
		roomNumLabel = new JLabel("Room Number");
		roomNumLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		roomNumLabel.setBounds(659, 359, 134, 35);
		contentPane.add(roomNumLabel);
		
		roomTypeCombobox = new JComboBox();
		roomTypeCombobox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				roomDetails();
				
				
			}
		});
		roomTypeCombobox.setFont(new Font("Tahoma", Font.PLAIN, 19));
		roomTypeCombobox.setModel(new DefaultComboBoxModel(new String[] {"Select", "Standard", "Luxury", "Presidential Suite"}));
		roomTypeCombobox.setBounds(801, 259, 270, 35);
		contentPane.add(roomTypeCombobox);
		
		roomNumCombobox = new JComboBox();
		roomNumCombobox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String roomNo = (String) roomNumCombobox.getSelectedItem();
				try {
					
					ResultSet rs = Select.getData("select * from room where roomNo = '"+roomNo+"'");
				
					while(rs.next())
					{
						priceTextField.setText(rs.getString(4));
					}
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
			}
		});
		roomNumCombobox.setBounds(801, 359, 270, 35);
		contentPane.add(roomNumCombobox);
		
		priceLabel = new JLabel("Price\r\n");
		priceLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		priceLabel.setBounds(659, 455, 134, 35);
		contentPane.add(priceLabel);
		
		priceTextField = new JTextField();
		priceTextField.setColumns(10);
		priceTextField.setBounds(801, 444, 270, 49);
		contentPane.add(priceTextField);
		
		bookRoomButton = new JButton("Book Room");
		bookRoomButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = 1 ;
				String name = nameTextField.getText();
				String phoneNo = phoneTextField.getText();
				String Nid = NIDTextField.getText();
				String email = emailTextField.getText();
				String checkIN = checkInTextField.getText()	;
				String bed = (String)bedComboBox.getSelectedItem();
				String roomType = (String)roomTypeCombobox.getSelectedItem();
				String roomNo = (String)roomNumCombobox.getSelectedItem();
				String price = priceTextField.getText()	;
				
				String Query = "select max(id) from customer";
				try {
					
					ResultSet rs = Select.getData(Query);
					while(rs.next()) {
						id = rs.getInt(1);
						id = id + 1;
						
						if (!price.equals("")) {
							
							Query = "update room set status = 'Booked' where roomNo = '"+roomNo+"'";
							InsertDeleteUpdate.setData(Query,"");
							Query = "insert into customer (id,Nid,name,phoneNo,email,checkIn,roomNo,bed,roomType,pricePerDAY) values ("+id+","+Nid+",'"+name+"', '"+phoneNo+"','"+email+"', '"+checkIN+"', '"+roomNo+"', '"+bed+"', '"+roomType+"',"+price+")";
							InsertDeleteUpdate.setData(Query, "Customer Check In Successful");
							setVisible(false);
							new CheckIn().setVisible(true);
						}
					}
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
				
				
				}
		});
		bookRoomButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		bookRoomButton.setBounds(828, 566, 180, 49);
		contentPane.add(bookRoomButton);
		
		checkInTextField.setEditable(false);
		priceTextField.setEditable(false);
		SimpleDateFormat myFormat = new SimpleDateFormat("dd/MM/yyyy");
		Calendar cal = Calendar.getInstance();
		checkInTextField.setText(myFormat.format(cal.getTime()));
		
	}
	
	

	public void roomDetails() {
		String bed;
		String roomType;
		String roomNo;
		String price;
		
		
		//roomNumber
		roomNumCombobox.removeAllItems();
		//price
		priceTextField.setText("");
		
		bed = (String)bedComboBox.getSelectedItem();
		roomType = (String)roomTypeCombobox.getSelectedItem();
		
		try {
			
			ResultSet rs = Select.getData("select * from room where bed = '"+bed+"' and roomType = '"+roomType+"' and status='Not Booked'") ;
			
			while(rs.next())
			{
				roomNumCombobox.addItem(rs.getString(1));
			}
			
		} catch (Exception e1) {
			
			JOptionPane.showMessageDialog(null, e1);
		}
		
	}
	
	
	
}
