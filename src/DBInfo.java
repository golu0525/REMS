import java.sql.Connection;
import java.sql.DriverManager;



public class DBInfo {
	static Connection con;
	static{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			//System.out.println("Driver loaded");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/realestate", "root", "abhi");
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
}
