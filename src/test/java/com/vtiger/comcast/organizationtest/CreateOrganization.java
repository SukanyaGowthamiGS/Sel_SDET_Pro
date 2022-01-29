package com.vtiger.comcast.organizationtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.crm.GenericLibrary.ExcelUtility;
import com.crm.GenericLibrary.FileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.WebDriverUtility;

public class CreateOrganization {
	public static void main(String[] args) throws Throwable {
		
		/*Object Creation for Lib*/
			JavaUtility jLib = new JavaUtility();
			WebDriverUtility wLib = new WebDriverUtility();
			FileUtility fLib = new FileUtility();
			ExcelUtility eLib = new ExcelUtility();
			
			int randomInt = jLib.getRandom();
			
			/*common Data*/
			String USERNAME = fLib.getPropertyKeyValue("username");
			String PASSWORD = fLib.getPropertyKeyValue("password");
			String URL = fLib.getPropertyKeyValue("url");
			String BROWSER = fLib.getPropertyKeyValue("browser");
			
			/*test script Data*/
			String orgName = eLib.getDataFromExcel("org", 1, 2) + randomInt;
			
			/* Navigate to app*/
			WebDriver driver=null;
			if(BROWSER.equals("firefox")) {
				driver= new FirefoxDriver();
				}
			else if(BROWSER.equals("chrome")) {
				driver= new ChromeDriver();
			}
			else {
				driver= new InternetExplorerDriver();
			}
			
			wLib.waitUntilPageLoad(driver);
	        driver.get(URL);
	        
	        driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			driver.findElement(By.name("user_password")).sendKeys( PASSWORD);
			driver.findElement(By.name("submitButton")).click();
			
			driver.findElement(By.xpath("//a[text()='Organizations']")).click();
			driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
            driver.findElement(By.name("accountname")).sendKeys(orgName);
            driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
            
	        

	}

}
