package comcast_Testng;

import org.testng.annotations.Test;

public class DependsonmethodsTest {
	@Test
	public void createCustomerTest() {
		System.out.println("create users for wise illusion");
	}
	
	@Test(dependsOnMethods="createCustomerTest")
	public void modifyCustomerTest() {
		System.out.println("edit the data of users in wise illusion");
	}
	
	@Test(dependsOnMethods={"createCustomerTest","modifyCustomerTest"})
	public void deleteCustomerTest() {
		System.out.println("delete users for wise illusion");
	}

}
