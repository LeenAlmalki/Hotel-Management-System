import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Desktop;

import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.JScrollPane;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;
import java.io.FileOutputStream;

public class CheckOut extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	//labels
	private JLabel label;
	private JLabel searchRoomLabel;
	private JLabel NameLabel;
	private JLabel checkInLabel;
	private JLabel checkOutLabel;
	private JLabel emailLabel;
	private JLabel phoneNumLabel;
	private JLabel stayDayLabel;
	private JLabel pricePerDayLabel;
	private JLabel totalAmountLabel;
	
	//buttons
	private JButton back;
	private JButton searchRoomButton;
	
	//text fields
	private JTextField searchRoomTextField;
	private JTextField nameTextField;
	private JTextField checkInTextField;
	private JTextField checkOutTextField;
	private JTextField emailTextField;
	private JTextField phoneNumTextField;
	private JTextField dayStayTextField;
	private JTextField pricePerDayTextField;
	private JTextField totalAmountTextField;
	
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckOut frame = new CheckOut();
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
	public CheckOut() {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				ResultSet rs = Select.getData("select * from customer where checkOut is NULL");
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				try {
					
					while (rs.next())
					{
						model.addRow(new Object[] {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10)});
					}
					rs.close();
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1145, 753);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(39, 468, 1046, 238);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "National ID", "Name", "Phone Number", "Email", "Check IN Date", "Room Number", "Bed", "RoomType", "Price per Day"
			}
		));
		table.getColumnModel().getColumn(3).setPreferredWidth(79);
		table.getColumnModel().getColumn(6).setPreferredWidth(79);
		table.setBorder(new LineBorder(Color.BLACK));
		
		label = new JLabel("Customer Check OUT");
		label.setFont(new Font("Tahoma", Font.BOLD, 24));
		label.setBounds(39, 31, 284, 51);
		contentPane.add(label);
		
		back = new JButton("back");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Home() .setVisible(true);
			}
		});
		back.setBounds(1018, 25, 85, 21);
		contentPane.add(back);
		
		searchRoomButton = new JButton("Search\r\n");
		searchRoomButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String roomNo = searchRoomTextField.getText();
				try {
					
					ResultSet rs = Select.getData("select * from customer where roomNo = '"+roomNo+"' and checkOut is NULL");
					
					if (rs.next())
					{
						searchRoomTextField.setEditable(false);
						id = rs.getInt(1);
						nameTextField.setText(rs.getString(3));
						emailTextField.setText(rs.getString(5));
						phoneNumTextField.setText(rs.getString(4));
						checkInTextField.setText(rs.getString(6));
						pricePerDayTextField.setText(rs.getString(10));
						
						SimpleDateFormat myFormat = new SimpleDateFormat("dd/MM/yyyy");
						Calendar cal = Calendar.getInstance();
						checkOutTextField.setText(myFormat.format(cal.getTime()));
						String  dateBeforeString = rs.getString(6);
						Date dateBefore = myFormat.parse(dateBeforeString);
						
						String dateAfterString = myFormat.format(cal.getTime());
						java.util.Date dateAfter = myFormat.parse(dateAfterString);
						
						long difference =  dateAfter.getTime() - dateBefore.getTime();
						
						int dayStay = (int) (difference/(1000*60*60*24));
						
						if(dayStay == 0)
							dayStay = 1;
						
						 dayStayTextField.setText(String.valueOf(dayStay));
						 
						 float price = Float.parseFloat(pricePerDayTextField.getText());
						 
						 
						 totalAmountTextField.setText(String.valueOf(dayStay * price));
						 
						 emailTextField.setText(rs.getString(5));
						 
						 roomType = rs.getString(9);
						 bed = rs.getString(8);	
						
					}
					
					else {
						JOptionPane.showMessageDialog(null, "Room number does not exist or booked");
					}
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
			}
		});
		searchRoomButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		searchRoomButton.setBounds(642, 126, 112, 31);
		contentPane.add(searchRoomButton);
		
		searchRoomLabel = new JLabel("Room Number\r\n");
		searchRoomLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		searchRoomLabel.setBounds(299, 126, 144, 23);
		contentPane.add(searchRoomLabel);
		
		searchRoomTextField = new JTextField();
		searchRoomTextField.setBounds(466, 126, 112, 32);
		contentPane.add(searchRoomTextField);
		searchRoomTextField.setColumns(10);
		
		NameLabel = new JLabel("Customer Name\r\n");
		NameLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		NameLabel.setBounds(32, 195, 120, 31);
		contentPane.add(NameLabel);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(162, 197, 186, 34);
		contentPane.add(nameTextField);
		nameTextField.setColumns(10);
		
		checkInLabel = new JLabel("Check In Date\r\n");
		checkInLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		checkInLabel.setBounds(32, 268, 120, 31);
		contentPane.add(checkInLabel);
		
		checkInTextField = new JTextField();
		checkInTextField.setColumns(10);
		checkInTextField.setBounds(162, 270, 186, 34);
		contentPane.add(checkInTextField);
		
		checkOutLabel = new JLabel("Check Out Date");
		checkOutLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		checkOutLabel.setBounds(380, 268, 120, 31);
		contentPane.add(checkOutLabel);
		
		checkOutTextField = new JTextField();
		checkOutTextField.setColumns(10);
		checkOutTextField.setBounds(520, 270, 186, 34);
		contentPane.add(checkOutTextField);
		
		emailLabel = new JLabel("Customer Email");
		emailLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		emailLabel.setBounds(380, 195, 120, 31);
		contentPane.add(emailLabel);
		
		emailTextField = new JTextField();
		emailTextField.setColumns(10);
		emailTextField.setBounds(520, 197, 186, 34);
		contentPane.add(emailTextField);
		
		phoneNumLabel = new JLabel("Customer Phone Number");
		phoneNumLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		phoneNumLabel.setBounds(728, 195, 215, 31);
		contentPane.add(phoneNumLabel);
		
		phoneNumTextField = new JTextField();
		phoneNumTextField.setColumns(10);
		phoneNumTextField.setBounds(935, 197, 186, 34);
		contentPane.add(phoneNumTextField);
		
		stayDayLabel = new JLabel("Number of Days Stay");
		stayDayLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		stayDayLabel.setBounds(726, 268, 158, 31);
		contentPane.add(stayDayLabel);
		
		dayStayTextField = new JTextField();
		dayStayTextField.setColumns(10);
		dayStayTextField.setBounds(935, 270, 186, 34);
		contentPane.add(dayStayTextField);
		
		pricePerDayLabel = new JLabel("Price Per Day");
		pricePerDayLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		pricePerDayLabel.setBounds(32, 342, 120, 31);
		contentPane.add(pricePerDayLabel);
		
		pricePerDayTextField = new JTextField();
		pricePerDayTextField.setColumns(10);
		pricePerDayTextField.setBounds(162, 339, 186, 34);
		contentPane.add(pricePerDayTextField);
		
		totalAmountLabel = new JLabel("Total Amount");
		totalAmountLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		totalAmountLabel.setBounds(380, 342, 120, 31);
		contentPane.add(totalAmountLabel);
		
		totalAmountTextField = new JTextField();
		totalAmountTextField.setColumns(10);
		totalAmountTextField.setBounds(520, 339, 186, 34);
		contentPane.add(totalAmountTextField);
		
		
		nameTextField.setEditable(false);
		checkInTextField.setEditable(false);
		checkOutTextField.setEditable(false);
		emailTextField.setEditable(false);
		phoneNumTextField.setEditable(false);
		dayStayTextField.setEditable(false);
		pricePerDayTextField.setEditable(false);
		totalAmountTextField.setEditable(false);
		
		checkOutButton = new JButton("Check Out");
		checkOutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String name = nameTextField.getText();
				String phone = phoneNumTextField.getText();
				String email = emailTextField.getText();
				String checkOut = checkOutTextField.getText();
				String stayDay = dayStayTextField.getText();
				String amount = totalAmountTextField.getText();
				roomNo = searchRoomTextField.getText();
				
				Query = "update customer set numberOfDayStay ='"+stayDay+"' , totalAmount = '"+amount+"' , checkOut = '"+checkOut+"' where id='"+id+"'";
				
				InsertDeleteUpdate.setData(Query, "");
				
				Query = "update room set status = 'Not Booked' where roomNo = '"+roomNo+"' ";
				
				InsertDeleteUpdate.setData(Query, "");
				
				//here
				String path = "C:/Users/leena/Downloads";
				com.itextpdf.text.Document doc = new com.itextpdf.text.Document();
				
				try {
					
					PdfWriter.getInstance(doc, new FileOutputStream(path+""+id+".pdf"));
				
					doc.open ();
					
					Paragraph paragraph1 = new Paragraph("                                                                       Effat Hotel\n");
					doc.add(paragraph1);
					
					Paragraph paragraph2 = new Paragraph("****************************************************************************************************************");
					doc.add(paragraph2);
					
					Paragraph paragraph3 = new Paragraph("\tBill ID:  "+id+" \nCustomer Details:\nName: "+name+" \nPhone Number: "+phone+" \nEmail: "+email+" \n");
					doc.add(paragraph3);
					
					doc.add(paragraph2);
					
					Paragraph paragraph4 = new Paragraph("\tRoom Details:  \nNumber: "+searchRoomTextField.getText()+" \nType: "+roomType+" \nBed: "+bed+" \nPrice Per Day: " +pricePerDayTextField.getText()+"");
					doc.add(paragraph4);
					
					doc.add(paragraph2);
					
					PdfPTable table = new PdfPTable(4);
					table.addCell("Check IN Date: " + checkInTextField.getText());
					table.addCell("Check OUT Date: " + checkOut);
					table.addCell("Number of Days Stayed:  " + stayDay);
					table.addCell("Total Amount: " + amount + " SAR");
					
					doc.add(table);
					
					doc.add(paragraph2);
					
					Paragraph paragraph5 = new Paragraph("                                                                       THANK YOU FOR CHOOSING EFFAT HOTEL");
					doc.add(paragraph5);
	
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
				
				doc.close();
				
				int a = JOptionPane.showConfirmDialog(null, "Do you want to print the bill?" , "Select", JOptionPane.YES_NO_OPTION);
				
				if(a==0)
				{
					try {
						Desktop.getDesktop().open(new File(path+""+id+".pdf"));
						 setVisible(false);
							new CheckOut() . setVisible(true);
						
						
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, e2);
				}
					
					
					 if (a==1) {
						 setVisible(false);
							new CheckOut() . setVisible(true);
						
					} {
						
						
					}
				
				
			}
		}});
		checkOutButton.setFont(new Font("Tahoma", Font.PLAIN, 19));
		checkOutButton.setBounds(466, 411, 131, 31);
		contentPane.add(checkOutButton);
		
	}
	
	int id = 0;
	String Query;
	String roomType;
	String bed;
	String roomNo;
	private JButton checkOutButton;
}
