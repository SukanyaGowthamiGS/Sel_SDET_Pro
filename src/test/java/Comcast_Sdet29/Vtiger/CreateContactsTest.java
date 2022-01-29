package Comcast_Sdet29.Vtiger;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjPomRepository.ContactInfoPage;
import com.crm.ObjPomRepository.ContactsPage;
import com.crm.ObjPomRepository.CreateNewContactPage;
import com.crm.ObjPomRepository.CreateNewOrganizationPage;
import com.crm.ObjPomRepository.HomePage;
import com.crm.ObjPomRepository.OrganizationInfoPage;
import com.crm.ObjPomRepository.OrganizationsPage;

@Listeners(com.crm.GenericLibrary.ListnerImpClass.class)
public class CreateContactsTest extends BaseClass{

		@Test(retryAnalyzer= com.crm.GenericLibrary.RetryImpClass.class,groups="Smoke")
		public void createcontact() throws Throwable {
			//read test data
			 String lastName= eLib.getDataFromExcel("contacts", 1, 2) +"_"+ jLib.getRandom();
			// System.out.println(lastName);
			 
			 // navigate to contacts
			 HomePage hp= new HomePage(driver);
			 hp.getContactslink().click();
			 
			 //navigate to create contact page
			 ContactsPage op= new ContactsPage(driver);
			 op.getCreatecontact().click();

			 //create contact
			 CreateNewContactPage cnop= new CreateNewContactPage(driver);
			 cnop.createCont(lastName);
			 
			 // verify
			 ContactInfoPage cp= new ContactInfoPage(driver);
			 String actMsg =cp.getConsucheaderMsg().getText();
			 //System.out.println(actMsg);
			 
			 if(actMsg.contains(lastName)) {
				 System.out.println("contact created == PASS");
				 
			 }else {
				 System.out.println("contact not created == FAIL");
			 }
		}
		
		@Test(retryAnalyzer= com.crm.GenericLibrary.RetryImpClass.class,groups={"Smoke","Regression"})
		public void createcontactwithorg( ) throws Throwable{
			 //read test data
			 String lastName= eLib.getDataFromExcel("contacts", 1, 2) +"_"+ jLib.getRandom();
			 String orgName= eLib.getDataFromExcel("org", 1, 2) +"_"+ jLib.getRandom();
			 
			/* first we are creating organization then create contact because in vtiger data created local to pc so
			 */
			 
			 //navigate to org
			 HomePage hp= new HomePage(driver);
			 hp.getOrganizationlink().click();
			 
			 //navigate to create Org page
			 OrganizationsPage op= new OrganizationsPage(driver);
			 op.getCreateOrgImg().click();

			 //step5 : create org
			 CreateNewOrganizationPage cnop= new CreateNewOrganizationPage(driver);
			 cnop.createOrg(orgName);
			 
			 //wait for element
			 OrganizationInfoPage opp= new OrganizationInfoPage(driver);
			 wLib.waitForElementVisibility(driver,opp.getSuccesfullMsg());
			 
			 //verification for organization data
			 String actSucMsg =opp.getSuccesfullMsg().getText();
			 Assert.assertEquals(actSucMsg.contains(orgName), true);
			 System.out.println("org is created successfully == PASS"); 
	         
			 //step6: navigate to contacts
			 hp.getContactslink().click();
			 
			 //step7: navigate to create contact page
			 ContactsPage cop= new ContactsPage(driver);
			 cop.getCreatecontact().click();

			 //step8 : create contact
			 CreateNewContactPage cnop1= new CreateNewContactPage(driver);
			 cnop1.createCont(orgName,lastName);
			 //stepp9: Verify 
			 ContactInfoPage cp= new ContactInfoPage(driver);
			 String actMsg =cp.getConsucheaderMsg().getText();
			 //System.out.println(actMsg);
		
			 Assert.assertEquals(actMsg.contains(lastName), true);
			 System.out.println("contact created == PASS");
			 
			 
		}
	}



