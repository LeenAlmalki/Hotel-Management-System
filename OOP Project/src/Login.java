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

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField;
	private JLabel lblNewLabel;

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
		setBounds(100, 100, 439, 373);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		textField_1 = new JTextField();
		textField_1.setBounds(45, 112, 212, 40);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(45, 199, 212, 40);
		contentPane.add(textField);
		
		JLabel user = new JLabel("User id");
		user.setFont(new Font("Tahoma", Font.PLAIN, 17));
		user.setBounds(45, 89, 94, 13);
		contentPane.add(user);
		
		JLabel pass = new JLabel("Password");
		pass.setFont(new Font("Tahoma", Font.PLAIN, 17));
		pass.setBounds(45, 176, 94, 13);
		contentPane.add(pass);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement","root","");
					Statement stmt = conn.createStatement();
					String sql = "Select * from login where userID = '"+user.getText()+"' and  Password = '"+pass.getText()+"' ";
					ResultSet result = stmt.executeQuery(sql) ;
					if(result.next())
						JOptionPane.showMessageDialog(null, "Successfull Login");
					else
						JOptionPane.showMessageDialog(null, "Incorrect user ID or password");
					conn.close();
				} catch(Exception e1) {
					System.out.println(e1);
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setBounds(158, 282, 110, 29);
		contentPane.add(btnNewButton);
		
		lblNewLabel = new JLabel("Welcome Back");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(146, 30, 203, 29);
		contentPane.add(lblNewLabel);
	}
}
