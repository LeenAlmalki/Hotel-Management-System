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
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	
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
		
		JLabel lblNewLabel = new JLabel("Customer Check IN");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(45, 35, 270, 49);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Home() .setVisible(true);
			}
		});
		btnNewButton.setBounds(1005, 24, 85, 21);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(45, 166, 100, 35);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(206, 163, 270, 49);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Phone Number ");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(45, 259, 138, 35);
		contentPane.add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(206, 256, 270, 49);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("National ID");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(45, 359, 138, 35);
		contentPane.add(lblNewLabel_1_1_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(206, 356, 270, 49);
		contentPane.add(textField_2);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Email");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1.setBounds(45, 458, 138, 35);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(206, 455, 270, 49);
		contentPane.add(textField_3);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Check in Date\r\n");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_1.setBounds(45, 555, 138, 35);
		contentPane.add(lblNewLabel_1_1_1_1_1);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(206, 541, 270, 49);
		contentPane.add(textField_4);
		
		JLabel lblNewLabel_1_2 = new JLabel("Bed");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(659, 166, 100, 35);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Room Type");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_2_1.setBounds(659, 259, 134, 35);
		contentPane.add(lblNewLabel_1_2_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 19));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select", "Single", "Double", "Triple"}));
		comboBox.setBounds(801, 166, 270, 35);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Room Number");
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_2_1_1.setBounds(659, 359, 134, 35);
		contentPane.add(lblNewLabel_1_2_1_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Select", "Standard", "Luxury", "Suite", "Presidential Suite"}));
		comboBox_1.setBounds(801, 259, 270, 35);
		contentPane.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(801, 359, 270, 35);
		contentPane.add(comboBox_2);
		
		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("Price\r\n");
		lblNewLabel_1_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_2_1_1_1.setBounds(659, 455, 134, 35);
		contentPane.add(lblNewLabel_1_2_1_1_1);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(801, 444, 270, 49);
		contentPane.add(textField_5);
		
		JButton btnNewButton_1 = new JButton("Find Room");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_1.setBounds(870, 566, 138, 49);
		contentPane.add(btnNewButton_1);
		
		textField_4.setEditable(false);
		textField_5.setEditable(false);
		SimpleDateFormat myFormat = new SimpleDateFormat("yyyy/MM/dd");
		Calendar cal = Calendar.getInstance();
		textField_4.setText(myFormat.format(cal.getTime()));
		
		
		comboBox_1.removeAllItems();
		textField_5.setText("");
		String bed = (String)comboBox.getSelectedItem();
		String room = (String)comboBox_1.getSelectedItem();
		
	
		
	}
	
	
	
	
	
	
}
