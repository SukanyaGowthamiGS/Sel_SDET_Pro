package comcast_vtiger.Pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.GenericLibrary.ExcelUtility;
import com.crm.GenericLibrary.FileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.WebDriverUtility;
import com.crm.ObjPomRepository.CreateNewOrganizationPage;
import com.crm.ObjPomRepository.HomePage;
import com.crm.ObjPomRepository.LoginPage;
import com.crm.ObjPomRepository.OrganizationInfoPage;
import com.crm.ObjPomRepository.OrganizationsPage;

public class CreateOrgwithIndustryTest {
	public static void main(String[] args) throws Throwable {
		//Create Objects
		ExcelUtility eLib= new ExcelUtility();
		JavaUtility jLib= new JavaUtility();
		FileUtility fLib= new FileUtility();
		WebDriverUtility wLib= new WebDriverUtility();
		
		WebDriver driver= null;
		
		
	//read common data
	 String BROWSER =fLib.getPropertyKeyValue("browser");
	 String URL= fLib.getPropertyKeyValue("url");
	 String Username = fLib.getPropertyKeyValue("username");
	 String Password =fLib.getPropertyKeyValue("password");
	 
	 //read test data
	 String orgName= eLib.getDataFromExcel("org", 1, 2) +"_"+ jLib.getRandom();
	 String Industry= eLib.getDataFromExcel("org",4 , 3);
	 //System.out.println(Industry);
	 //System.out.println(orgName);
	 
	 //step1: launch the browser
	 if(BROWSER.equals("firefox")) {
		 driver= new FirefoxDriver();
	 }else if(BROWSER.equals("chrome"))
	 {
		 driver= new ChromeDriver();
	 }else {
		 driver= new ChromeDriver();
	 }
	 
	 //step2: Login to application
	 wLib.waitUntilPageLoad(driver);
	 driver.get(URL);
	 
	 LoginPage lp= new LoginPage(driver);
	 lp.loginToApp(Username,Password);
	 
	 //step3: navigate to organization
	 HomePage hp= new HomePage(driver);
	 hp.getOrganizationlink().click();
	 
	 //step4: navigate to create organization page
	 OrganizationsPage op= new OrganizationsPage(driver);
	 op.getCreateOrgImg().click();

	 //step5 : create organization with industry
	 CreateNewOrganizationPage cnop= new CreateNewOrganizationPage(driver);
	 
	 wLib.select(cnop.getIndustries(), Industry);
	 cnop.createOrg(orgName);
	 
	 //step6: verify
	 OrganizationInfoPage opp= new OrganizationInfoPage(driver);
	 
	 String actSucMsg =opp.getIndustryMsg().getText();
	 //System.out.println(actSucMsg);
	 
	 if(actSucMsg.contains(Industry)) {
		 System.out.println("org is created with industry"+actSucMsg+" == PASS");
	   }
	 else {
		 System.out.println("org is not created == FAIL");
	   }
	 
	 //step7:LOGOUT
	 hp.logout();
	 
	 //step8: close the Browser
	 driver.quit();

		}
}
