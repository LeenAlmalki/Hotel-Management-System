import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.DropMode;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Guest1 extends JFrame {
	private JTextField txtGfdhd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Guest1 frame = new Guest1();
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
	public Guest1() {
		setTitle("Guest");
		getContentPane().setBackground(new Color(238, 238, 238));
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Guest ID ");
		lblNewLabel.setBounds(14, 92, 66, 33);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Enter");
		btnNewButton.setBounds(138, 224, 147, 25);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		getContentPane().add(btnNewButton);
		
		txtGfdhd = new JTextField();
		txtGfdhd.setBounds(94, 92, 137, 33);
		getContentPane().add(txtGfdhd);
		txtGfdhd.setColumns(4);
	}

}
