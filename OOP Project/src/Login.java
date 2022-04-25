import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login implements ActionListener {

	public static void main(String[] args) {
		
		JPanel panel = new JPanel();
		JFrame frame = new JFrame();
		frame.setSize(100,100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.add(panel);
		
		panel.setLayout(null);
		
		// welcome phrase 
		JLabel welcome = new JLabel("Welcome Back ");
		welcome.setBounds(10, 0, 100, 25);
		panel.add(welcome);
		
		// user label
		JLabel label = new JLabel("User");
		label.setBounds(10, 20, 80, 25);
		panel.add(label);
		
		// user text field 
		JTextField userText = new JTextField(20);
		userText.setBounds(100, 20, 165, 25);
		panel.add(userText);
		
		// password label
		JLabel passwordLabel = new JLabel ("Password");
		passwordLabel.setBounds(10, 50, 80, 25);
		panel.add(passwordLabel);
		
		// password text field 
		JPasswordField passwordText = new JPasswordField();
		passwordText.setBounds(100, 50, 165, 25);
		panel.add(passwordText);
		
		// login button
		JButton button = new JButton("Login");
		button.setBounds(10, 80, 80, 25);
		button.addActionListener(new Login());
		panel.add(button);
		
		// success message 
		JLabel success =  new JLabel ("");
		success.setBounds(10, 110, 300, 25);
		panel.add(success);

		frame.setVisible(true);
	
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}

}
