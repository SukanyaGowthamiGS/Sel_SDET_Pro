package com.crm.GenericLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;


import com.crm.ObjPomRepository.HomePage;
import com.crm.ObjPomRepository.LoginPage;

public class BaseClass {
	
		
		public static WebDriver sDriver;
		public WebDriver driver;
		
		/* Object Creation for Libraries */
			public JavaUtility jLib = new JavaUtility();
			public WebDriverUtility wLib = new WebDriverUtility();
			public FileUtility fLib = new FileUtility();
			public ExcelUtility eLib = new ExcelUtility();
		
		@BeforeSuite(groups={"Smoke","Regression"})
		public void configBS() {
			System.out.println("========================connect to DB========================");

		}
		
		//@Parameters("browser")
		@BeforeClass(groups={"Smoke","Regression"})
		public void configBC(/*String BROWSER*/) throws Throwable {
			System.out.println("=============Launch the Browser=======");
			String BROWSER = fLib.getPropertyKeyValue("browser");
			String URL = fLib.getPropertyKeyValue("url");
			
			 //step1: launch the browser
			 if(BROWSER.equals("firefox")) {
				 driver= new FirefoxDriver();
			 }else if(BROWSER.equals("chrome"))
			 {
				 driver= new ChromeDriver();
			 }else {
				 driver= new ChromeDriver();
			 }
			 
			wLib.waitUntilPageLoad(driver);
			driver.manage().window().maximize();
			
			/* Navigate to app*/
			driver.get(URL);
			sDriver=driver;
		}
		
		@BeforeMethod(groups={"Smoke","Regression"})
		public void configBM() throws Throwable {
			/*common Data*/
			String USERNAME = fLib.getPropertyKeyValue("username");
			String PASSWORD = fLib.getPropertyKeyValue("password");
			
		    /* step 1 : login */
		    LoginPage login = new LoginPage(driver);
		    login.loginToApp(USERNAME, PASSWORD);
		}
		
		
		@AfterMethod
		public void configAM() {
		/*step 6 : logout*/
			HomePage home = new HomePage(driver);
	        home.logout();
		}
		
		@AfterClass
		public void configAC() {
			System.out.println("=============Close the Browser=======");
			driver.quit();
		}
		
		@AfterSuite
		public void configAS() {
			System.out.println("========================close DB========================");
		}
	}







