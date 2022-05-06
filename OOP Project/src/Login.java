import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JLabel lblNewLabel;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1145, 753);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		textField_1 = new JTextField();
		textField_1.setForeground(new Color(0, 0, 0));
		textField_1.setBounds(438, 210, 291, 40);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel user = new JLabel("User ID");
		user.setForeground(new Color(0, 0, 0));
		user.setFont(new Font("Tahoma", Font.PLAIN, 17));
		user.setBounds(284, 220, 94, 13);
		contentPane.add(user);
		
		JLabel pass = new JLabel("Password");
		pass.setForeground(new Color(0, 0, 0));
		pass.setFont(new Font("Tahoma", Font.PLAIN, 17));
		pass.setBounds(284, 290, 94, 13);
		contentPane.add(pass);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {	
				
				String userID = textField_1.getText();
				String password = passwordField.getText();
				
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement","root","");
					Statement stmt = conn.createStatement();
					String sql = "Select * from login where userID = '"+userID+"' and  Password = '"+password+"' ";
					ResultSet result = stmt.executeQuery(sql) ;
					
					if (userID.equals("") || password.equals("")) 
					{
						JOptionPane.showMessageDialog(null, "User Id and Password are required");
					}
					
					else if(result.next())
					{
						setVisible(false);
						new Home().setVisible(true);
					}
					else
						JOptionPane.showMessageDialog(null, "Incorrect user ID or password");
					conn.close();
				} catch(Exception e1) {
					System.out.println(e1);
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton.setBounds(499, 399, 161, 40);
		contentPane.add(btnNewButton);
		
		lblNewLabel = new JLabel("Login");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel.setBounds(550, 101, 203, 29);
		contentPane.add(lblNewLabel);
		
		passwordField = new JPasswordField();
		passwordField.setForeground(new Color(0, 0, 0));
		passwordField.setBounds(438, 292, 291, 40);
		contentPane.add(passwordField);
	}
}
