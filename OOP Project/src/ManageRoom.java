import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.Rectangle;
import java.awt.Point;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.DefaultComboBoxModel;
import java.sql.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class ManageRoom extends JFrame {

	private JPanel contentPane;
	//labels
	private JLabel roomNumberLabel;
	private JLabel manageRoomsLabel;
	private JLabel roomTypeLabel;
	private JLabel bedLabel;
	private JLabel priceLabel;
	//textFields 
	private JTextField roomNum;
	private JTextField price_;
	//combobox
	private JComboBox bed_;
	private JComboBox roomType_;
	//buttons
	private JButton addRoom;
	private JButton back;
	///table
	private JTable table;

	/**

* Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageRoom frame = new ManageRoom();
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
	public ManageRoom() {
		addComponentListener(new ComponentAdapter() {
   			@Override
   			public void componentShown(ComponentEvent e) {
   				
   				ResultSet rs = Select.getData("select * from room");
   				DefaultTableModel model = (DefaultTableModel)table.getModel();
   				try {
   					
   					while(rs.next()) {
   						model.addRow(new Object[] {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)});
   					}
   					
   					rs.close();
   					
   				} catch (Exception e2) {
   					JOptionPane.showMessageDialog(null, e2);
   				}
   				
   			}
   		});
   		setLocation(new Point(50, 118));
   		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   		setBounds(100, 100, 1145, 753);
   		contentPane = new JPanel();
   		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
   		setContentPane(contentPane);
   		contentPane.setLayout(null);
   		
   		JScrollPane scrollPane = new JScrollPane();
   		scrollPane.setFont(new Font("Tahoma", Font.PLAIN, 10));
   		scrollPane.setBounds(45, 51, 505, 594);
   		contentPane.add(scrollPane);
   		
   		table = new JTable();
   		scrollPane.setViewportView(table);
   		table.setToolTipText("");
   		table.setForeground(Color.BLACK);
   		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
   		table.setBorder(new LineBorder(new Color(0, 0, 0)));
   		table.setBackground(Color.LIGHT_GRAY);
   		table.setModel(new DefaultTableModel(
   			new Object[][] {
   			},
   			new String[] {
   				"Room Number", "Room Type", "Bed", "Room Price", "Status"
   			}
   		));
   		table.getColumnModel().getColumn(0).setPreferredWidth(82);
   		
   		manageRoomsLabel = new JLabel("Manage Rooms");
   		manageRoomsLabel.setHorizontalAlignment(SwingConstants.CENTER);
   		manageRoomsLabel.setBounds(692, 27, 318, 86);
   		manageRoomsLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
   		contentPane.add(manageRoomsLabel);
   		
   		roomNumberLabel = new JLabel("Room Number");
   		roomNumberLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
   		roomNumberLabel.setBounds(619, 144, 174, 37);
   		contentPane.add(roomNumberLabel);
   		
   		roomTypeLabel = new JLabel("Room Type");
   		roomTypeLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
   		roomTypeLabel.setBounds(619, 238, 174, 37);
   		contentPane.add(roomTypeLabel);
   		
   		bedLabel = new JLabel("Bed");
   		bedLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
   		bedLabel.setBounds(619, 343, 174, 37);
   		contentPane.add(bedLabel);
   		
   		priceLabel = new JLabel("Price");
   		priceLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
   		priceLabel.setBounds(619, 430, 174, 37);
   		contentPane.add(priceLabel);
   		
   		roomNum = new JTextField();
   		roomNum.setBounds(843, 144, 167, 33);
   		contentPane.add(roomNum);
   		roomNum.setColumns(10);
   		
   	
   		roomType_ = new JComboBox();
   		roomType_.setFont(new Font("Tahoma", Font.PLAIN, 20));
   		roomType_.setModel(new DefaultComboBoxModel(new String[] {"Select", "Standard", "Luxury", "Suite", "Presidential Suit"}));
   		roomType_.setBounds(846, 251, 164, 33);
   		contentPane.add(roomType_);
   		
   		price_ = new JTextField();
   		price_.setColumns(10);
   		price_.setBounds(843, 430, 167, 33);
   		contentPane.add(price_);
   		
   		bed_ = new JComboBox();
   		bed_.setFont(new Font("Tahoma", Font.PLAIN, 20));
   		bed_.setModel(new DefaultComboBoxModel(new String[] {"Select", "Single", "Double ", "Triple"}));
   		bed_.setBounds(843, 350, 164, 33);
   		contentPane.add(bed_);
   		
   		
   		// this button adds the room into the database
   		addRoom = new JButton("Add Room");
   		addRoom.addActionListener(new ActionListener() {
   			public void actionPerformed(ActionEvent e) {
   				String roomNo = roomNum.getText();
   				String roomType = (String)roomType_.getSelectedItem();
   				String bed = (String)bed_.getSelectedItem();
   				String price = price_.getText();
   				String Query = "insert into room values('"+roomNo+"', '"+roomType+"', '"+bed+"' , '"+price+"','Not Booked')";
   				InsertDeleteUpdate.setData(Query, "Successfully Updated!");
   				setVisible(false);
   				new ManageRoom().setVisible(true);
   	
   		}});
   		addRoom.setFont(new Font("Tahoma", Font.PLAIN, 21));
   		addRoom.setBounds(763, 542, 134, 37);
   		contentPane.add(addRoom);
   		
   		back = new JButton("Back");
   		back.addActionListener(new ActionListener() {
   			public void actionPerformed(ActionEvent e) {
   				setVisible(false);
   				new Home() .setVisible(true);
   			}
   		});
   		
   		back.setBounds(1036, 10, 85, 21);
   		contentPane.add(back);
   	}
	
	
	
}
