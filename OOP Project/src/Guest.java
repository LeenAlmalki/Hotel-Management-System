import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Guest extends JFrame{
	private JTextField textField;

	public Guest() {
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Guest ID");
		lblNewLabel.setBounds(14, 14, 61, 17);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(82, 11, 126, 23);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Enter");
		btnNewButton.setBounds(169, 224, 105, 25);
		getContentPane().add(btnNewButton);
		// TODO Auto-generated constructor stub
	}
}
