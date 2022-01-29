package comcast_selenium_framework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SelectQuery {

	public static void main(String[] args) throws Throwable{
		Connection conn = null;
		try {
			Driver driveRef= new Driver();
			DriverManager.registerDriver(driveRef);
			conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
			System.out.println("connection is done");
			Statement stat = conn.createStatement();
			String query = "select * from project";
			ResultSet result=stat.executeQuery(query);
			while (result.next()) {
				System.out.println(result.getString(1)+"\t"+result.getString(2)+"\t"+
			result.getString(3)+"/t"+result.getString(4));
				
			}
		}
			catch(Exception e) {
				
		}
		finally {
			conn.close();
			System.out.println("****close db****");
		}
	}

}
