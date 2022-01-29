package comcast_Testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleAssert {
	@Test
	public void createCustomerTest(){
		System.out.println("step_1");
		System.out.println("step_2");
		Assert.assertEquals("A", "b");
		System.out.println("step_3");
		Assert.assertEquals("A", "A");
		System.out.println("step_4");
	}
	@Test
	public void modifyCustomerTest(){
		System.out.println("=============================");
		Assert.assertEquals("A", "B");
		System.out.println("step_1");
		System.out.println("step_2");
		System.out.println("step_3");
	}

}

