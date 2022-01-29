package comcast_Testng;

import org.testng.annotations.Test;

public class InovactioncountTest {
	
	@Test(invocationCount=5)
	public void createCustomerTest() {
		System.out.println("create users for wise illusion");
	}
}
