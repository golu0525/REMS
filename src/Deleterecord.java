import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;


public class Deleterecord {
public static void main(String[] args) throws Exception{
	Connection conn=DBInfo.con;
	@SuppressWarnings("resource")
	Scanner sc=new Scanner(System.in);
	System.out.println("enter username to del that record");
	String uname=sc.nextLine();
	String query="delete from registration where username=?";
	PreparedStatement ps=conn.prepareStatement(query);
	ps.setString(1, uname);
	int i=ps.executeUpdate();
	System.out.println(i+"record deleted");conn.close();
	ps.close();
	
}
}
