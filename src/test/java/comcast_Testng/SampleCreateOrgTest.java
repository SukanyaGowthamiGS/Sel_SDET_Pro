package comcast_Testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SampleCreateOrgTest {
	
	@BeforeClass
	public void configBC() {
		System.out.println("========connect DB========");
	}
	@BeforeMethod
	public void configBM() {
		System.out.println("===login===");
	}
	
    @Test
    public void createOrgTest() {
    	System.out.println("navigate to organization");
    	System.out.println("Create organization");
    	System.out.println("verify");
    }
    
    @Test
    public void createOrgWithIndusTest() {
    	System.out.println("navigate to organization");
    	System.out.println("Create organization with industries");
    	System.out.println("verify");
    }
    
    @AfterMethod
    public void configAM() {
		System.out.println("===logout===");
	}	
    
    @AfterClass
    public void configAC() {
    	System.out.println("========close Browser=======");
    }
   
    
}
