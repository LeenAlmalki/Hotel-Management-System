import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.border.TitledBorder;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class DataLog extends JFrame {


	private JPanel contentPane;
	private JTable table;
	
	// text field
	private JTextField searchdateTextField;
	
	
	// button
	private JButton searchDateButton;
	
	//label
	private JLabel lblDataLog;
	private JLabel label2;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DataLog frame = new DataLog();
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
	public DataLog() {
		
		
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				ResultSet rs = Select.getData("select * from customer where checkOut is not NULL");
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				
				try {
					
					while (rs.next())
					{
						model.addRow(new Object[] {rs.getString(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), });
					}
					
					rs.close();
					
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
			}
		});
		
		setLocation(new Point(50, 118));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1145, 753);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblDataLog = new JLabel("Data Log");
		lblDataLog.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblDataLog.setBounds(32, 28, 291, 25);
		contentPane.add(lblDataLog);
		
		JButton back = new JButton("Back");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Home() .setVisible(true);
			}
		});
		back.setBounds(1012, 14, 105, 25);
		contentPane.add(back);
		
		label2 = new JLabel("Search by check out date");
		label2.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label2.setBounds(294, 87, 227, 17);
		contentPane.add(label2);
		
		searchdateTextField = new JTextField();
		searchdateTextField.setBounds(520, 88, 126, 23);
		contentPane.add(searchdateTextField);
		searchdateTextField.setColumns(10);
		
		searchDateButton = new JButton("Search");
		searchDateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String checkOutDate = searchdateTextField.getText();
				
				ResultSet rs = Select.getData("select * from customer where checkOut = '"+checkOutDate+"'");
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				model.setRowCount(0);
				
				try {
					
					while (rs.next())
					{
						model.addRow(new Object[] {rs.getString(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), });
					}
					
					rs.close();
					
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
				
				
			}
			
		});
		searchDateButton.setBounds(677, 87, 105, 25);
		contentPane.add(searchDateButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			
		});
		scrollPane.setBounds(47, 202, 1039, 341);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "National ID", "Name", "Phone Number", "Email", "Check In", "Room Number", "Bed", "Room Type", "Price Per Day", "Number of Days Stayed", "Total Amount", "Check Out"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(69);
		table.getColumnModel().getColumn(3).setPreferredWidth(80);
		table.getColumnModel().getColumn(6).setPreferredWidth(81);
		table.getColumnModel().getColumn(10).setPreferredWidth(128);
		
		
		SimpleDateFormat myDate =  new SimpleDateFormat("dd/MM/yyyy");
		Calendar cal = Calendar.getInstance();
		searchdateTextField.setText(myDate.format(cal.getTime()));
	}
}
