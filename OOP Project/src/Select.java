
import java.sql.*;

import javax.swing.JOptionPane;

public class Select {
	
	public static ResultSet getData(String query) {
		
		Connection conn = null;
		Statement st  = null;
		ResultSet rs =  null;
		
		try {
			
			conn = connection.getCon();
			st = conn.createStatement();
			rs=st.executeQuery(query);
			return rs;
			
			
		} catch (Exception e) {
			
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
		
		
		
		
		
	}
	
	

}
