package comcast_selenium_framework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class NonSelectQuery {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		int result=0;
		try {
			Driver driveRef= new Driver();
			DriverManager.registerDriver(driveRef);
			conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
			System.out.println("connection is done");
			Statement stat = conn.createStatement();
			String query = "insert into project values('TY_PROJ_004','Gowthami','15/01/2022','Wiseillusion','On Going',5)";
		    result = stat.executeUpdate(query);
			
		}catch(Exception e) {
		}finally {
			if(result==1) {
				System.out.println("Project inserted successfully");
				
			}
			else {
				System.out.println("Project is not inserted ");
			}
			conn.close();
			System.out.println("******close db******");
		}

	}

}
