import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class CheckOut extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JLabel lblNewLabel;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_1;
	private JTextField textField;
	private JLabel lblNewLabel_2;
	private JTextField textField_1;
	private JLabel lblNewLabel_3;
	private JTextField textField_2;
	private JLabel lblNewLabel_4;
	private JTextField textField_3;
	private JLabel lblNewLabel_5;
	private JTextField textField_4;
	private JLabel lblNewLabel_6;
	private JTextField textField_5;
	private JLabel lblNewLabel_7;
	private JTextField textField_6;
	private JLabel lblNewLabel_8;
	private JTextField textField_7;
	private JLabel lblNewLabel_9;
	private JTextField textField_8;
	private JButton btnNewButton_2;
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
		
		lblNewLabel = new JLabel("Customer Check OUT");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(39, 31, 284, 51);
		contentPane.add(lblNewLabel);
		
		btnNewButton = new JButton("back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Home() .setVisible(true);
			}
		});
		btnNewButton.setBounds(1018, 25, 85, 21);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Search\r\n");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1.setBounds(642, 126, 112, 31);
		contentPane.add(btnNewButton_1);
		
		lblNewLabel_1 = new JLabel("Room Number\r\n");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_1.setBounds(299, 126, 144, 23);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(466, 126, 112, 32);
		contentPane.add(textField);
		textField.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Customer Name\r\n");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(32, 195, 120, 31);
		contentPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(162, 197, 186, 34);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		lblNewLabel_3 = new JLabel("Check In Date\r\n");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(32, 268, 120, 31);
		contentPane.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(162, 270, 186, 34);
		contentPane.add(textField_2);
		
		lblNewLabel_4 = new JLabel("Check Out Date");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_4.setBounds(380, 268, 120, 31);
		contentPane.add(lblNewLabel_4);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(520, 270, 186, 34);
		contentPane.add(textField_3);
		
		lblNewLabel_5 = new JLabel("Customer Name\r\n");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_5.setBounds(380, 195, 120, 31);
		contentPane.add(lblNewLabel_5);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(520, 197, 186, 34);
		contentPane.add(textField_4);
		
		lblNewLabel_6 = new JLabel("Customer Phone Number");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_6.setBounds(728, 195, 215, 31);
		contentPane.add(lblNewLabel_6);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(935, 197, 186, 34);
		contentPane.add(textField_5);
		
		lblNewLabel_7 = new JLabel("Number of Days Stay");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_7.setBounds(726, 268, 158, 31);
		contentPane.add(lblNewLabel_7);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(935, 270, 186, 34);
		contentPane.add(textField_6);
		
		lblNewLabel_8 = new JLabel("Total Amount");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_8.setBounds(32, 342, 120, 31);
		contentPane.add(lblNewLabel_8);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(162, 339, 186, 34);
		contentPane.add(textField_7);
		
		lblNewLabel_9 = new JLabel("Customer Email");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_9.setBounds(380, 342, 120, 31);
		contentPane.add(lblNewLabel_9);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(520, 339, 186, 34);
		contentPane.add(textField_8);
		
		btnNewButton_2 = new JButton("Check Out");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnNewButton_2.setBounds(466, 412, 131, 31);
		contentPane.add(btnNewButton_2);
	}
}
