import java.sql.Connection;
import java.sql.DriverManager;

public class connection {
	public static Connection getCon() {
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement","root","");
			return conn;
			
		} catch (Exception e) {
			
			return null;
		}
		
	}
	


}
