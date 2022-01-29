package comcast_selenium_framework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class ProjectUnitTest {
	@Test
	public void projectUnitTest() throws Throwable {
	    String ProjectName="Lalstow";
		Connection conn = null;
		try {
			Driver driveRef= new Driver();
			DriverManager.registerDriver(driveRef);
			conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
			System.out.println("connection is done");
			Statement stat = conn.createStatement();
			String query = "select * from project";
			ResultSet result=stat.executeQuery(query);
			boolean flag = false;
			while( result.next()) {
				String actProjName = result.getString(3);
				if(actProjName.equals(ProjectName)) {
					flag= true;
				}
			}
			Assert.assertTrue(flag);
		}catch(Exception e) {
			
		}finally {
			conn.close();
			System.out.println("*****close db*****");
		}
	}

}
