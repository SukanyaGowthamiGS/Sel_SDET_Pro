package comcast_Testng;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;

public class SampleAssertTest extends BaseClass {
	@Test
	public void verifyHomePage() {
		System.out.println("*******test start***********");
		String expectedFile ="HomePage".trim();
		System.out.println("capture page title");
		String actTitle = driver.getTitle().trim();
		Assert.assertEquals(actTitle, expectedFile);
		System.out.println("*******test end***********");
	}
	
	@Test
	public void verifyLogoHomePage() {
		System.out.println("*******test start***********");
		System.out.println("capture the lo");
		boolean actStatus = driver.findElement(By.xpath("//img[@title='vtiger-crm-logo.gif'")).isDisplayed();
		Assert.assertTrue(actStatus);
		System.out.println("*******test end***********");
	}
	

}
