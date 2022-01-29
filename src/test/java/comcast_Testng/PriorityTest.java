package comcast_Testng;

import org.testng.annotations.Test;

public class PriorityTest {

	@Test(priority=2)
	public void createCustomerTest() {
		System.out.println("create users for wise illusion");
	}
	
	@Test(priority=3)
	public void modifyCustomerTest() {
		System.out.println("edit the data of users in wise illusion");
	}
	
	@Test(priority=1)
	public void deleteCustomerTest() {
		System.out.println("delete users for wise illusion");
	}
}
