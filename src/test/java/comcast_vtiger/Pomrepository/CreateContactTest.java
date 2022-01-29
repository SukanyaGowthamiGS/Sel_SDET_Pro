package comcast_vtiger.Pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.crm.GenericLibrary.ExcelUtility;
import com.crm.GenericLibrary.FileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.WebDriverUtility;
import com.crm.ObjPomRepository.ContactInfoPage;
import com.crm.ObjPomRepository.ContactsPage;
import com.crm.ObjPomRepository.CreateNewContactPage;
import com.crm.ObjPomRepository.HomePage;
import com.crm.ObjPomRepository.LoginPage;

public class CreateContactTest {
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
	 String lastName= eLib.getDataFromExcel("contacts", 1, 2) +"_"+ jLib.getRandom();
	// System.out.println(lastName);
	 
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
	 
	 //step3: navigate to contacts
	 HomePage hp= new HomePage(driver);
	 hp.getContactslink().click();
	 
	 //step4: navigate to create contact page
	 ContactsPage op= new ContactsPage(driver);
	 op.getCreatecontact().click();

	 //step5 : create contact
	 CreateNewContactPage cnop= new CreateNewContactPage(driver);
	 cnop.createCont(lastName);
	 
	 //step6: verify
	 ContactInfoPage cp= new ContactInfoPage(driver);
	 String actMsg =cp.getConsucheaderMsg().getText();
	 //System.out.println(actMsg);
	 
	 if(actMsg.contains(lastName)) {
		 System.out.println("contact created == PASS");
		 
	 }else {
		 System.out.println("contact not created == FAIL");
	 }
	 
	 //step7 : logout
	 hp.logout();
	 
	 //step8: close browser
	 driver.quit();
	}
}
	 


