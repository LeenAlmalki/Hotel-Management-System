import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Home extends JFrame {

	private JPanel contentPane;
	private JButton manageRoom;
	private JButton checkIn;
	private JButton checkOut;
	private JButton bill;
	private JButton logout;
	private JLabel label;
	 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1145, 753);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 manageRoom = new JButton("Manage Rooms");
		 manageRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new ManageRoom() .setVisible(true);
			}
		});
		 manageRoom.setFont(new Font("Tahoma", Font.PLAIN, 24));
		 manageRoom.setBounds(457, 342, 250, 37);
		contentPane.add(manageRoom);
		
		checkIn = new JButton("Customer Checkin");
		checkIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new CheckIn() .setVisible(true);
			}
		});
		checkIn.setFont(new Font("Tahoma", Font.PLAIN, 24));
		checkIn.setBounds(457, 401, 250, 37);
		contentPane.add(checkIn);
		
		 checkOut = new JButton("Customer Checkout");
		 checkOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CheckOut().setVisible(true);
			}
		});
		 checkOut.setFont(new Font("Tahoma", Font.PLAIN, 24));
		 checkOut.setBounds(457, 461, 250, 37);
		contentPane.add(checkOut);
		
		 bill = new JButton("Customer Detail Bill");
		 bill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CustomerBill().setVisible(true);
			}
		});
		 bill.setFont(new Font("Tahoma", Font.PLAIN, 24));
		 bill.setBounds(457, 523, 250, 37);
		contentPane.add(bill);
		
		 logout = new JButton("Logout");
		 logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				int a = JOptionPane.showConfirmDialog(null, "Are you sure you want to Logout?" , "Select" , JOptionPane.YES_NO_OPTION);
				if (a==0)
				{
					setVisible(false);
					new Login().setVisible(true);
				}
			}
		});
		 logout.setFont(new Font("Tahoma", Font.PLAIN, 24));
		 logout.setBounds(519, 585, 130, 37);
		contentPane.add(logout);
		
		 label = new JLabel("Effat Hotel");
		 label.setHorizontalAlignment(SwingConstants.CENTER);
		 label.setFont(new Font("Tahoma", Font.PLAIN, 96));
		 label.setBounds(184, 86, 806, 133);
		contentPane.add(label);
	}
}
