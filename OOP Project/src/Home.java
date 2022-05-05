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
		
		JButton btnNewButton = new JButton("Manage Rooms");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new ManageRoom() .setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnNewButton.setBounds(457, 342, 250, 37);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Customer Checkin");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new CheckIn() .setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnNewButton_1.setBounds(457, 401, 250, 37);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Customer Checkout");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CheckOut().setVisible(true);
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnNewButton_1_1.setBounds(457, 461, 250, 37);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("Customer Detail Bill");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CustomerBill().setVisible(true);
			}
		});
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnNewButton_1_1_1.setBounds(457, 523, 250, 37);
		contentPane.add(btnNewButton_1_1_1);
		
		JButton btnNewButton_1_1_1_1 = new JButton("Logout");
		btnNewButton_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				int a = JOptionPane.showConfirmDialog(null, "Are you sure you want to Logout?" , "Select" , JOptionPane.YES_NO_OPTION);
				if (a==0)
				{
					setVisible(false);
					new Login().setVisible(true);
				}
			}
		});
		btnNewButton_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnNewButton_1_1_1_1.setBounds(519, 585, 130, 37);
		contentPane.add(btnNewButton_1_1_1_1);
		
		JLabel lblNewLabel = new JLabel("Effat Hotel");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 96));
		lblNewLabel.setBounds(184, 86, 806, 133);
		contentPane.add(lblNewLabel);
	}
}
