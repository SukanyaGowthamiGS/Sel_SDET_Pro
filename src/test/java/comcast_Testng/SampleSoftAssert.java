package comcast_Testng;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SampleSoftAssert {
	
	@Test
	public void createCustomerTest(){
		System.out.println("step_1");
		System.out.println("step_2");
		SoftAssert s = new SoftAssert();
		s.assertEquals("A", "B");
		System.out.println("step_3");
		s.assertEquals("X", "Y");
		System.out.println("step_4");
		s.assertAll();
	}
	@Test
	public void modifyCustomerTest(){
		System.out.println("=============================");
		System.out.println("step_1");
		System.out.println("step_2");
		System.out.println("step_3");
		System.out.println("step_4");
	}


}
