package comcast.vtiger.TestNG;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjPomRepository.CreateNewOrganizationPage;
import com.crm.ObjPomRepository.HomePage;
import com.crm.ObjPomRepository.OrganizationInfoPage;
import com.crm.ObjPomRepository.OrganizationsPage;

@Listeners(com.crm.GenericLibrary.ListnerImpClass.class)
public class CreateOrgranizatnTest extends BaseClass {
	
	@Test(retryAnalyzer= com.crm.GenericLibrary.RetryImpClass.class/*groups="Smoke"*/)
	public void createOrgTest() throws Throwable {
		//read test data
		 String orgName= eLib.getDataFromExcel("org", 1, 28/*28*/) +"_"+ jLib.getRandom();
		 
		 //step3: navigate to org
		 HomePage hp= new HomePage(driver);
		 hp.getOrganizationlink().click();
		 
		 //step4: navigate to create Org page
		 OrganizationsPage op= new OrganizationsPage(driver);
		 op.getCreateOrgImg().click();

		 //step5 : create org
		 CreateNewOrganizationPage cnop= new CreateNewOrganizationPage(driver);
		 cnop.createOrg(orgName);
		 
		 //step6: verify
		 OrganizationInfoPage opp= new OrganizationInfoPage(driver);
		 wLib.waitForElementVisibility(driver,opp.getSuccesfullMsg());
		 
		 String actSucMsg =opp.getSuccesfullMsg().getText();
		// System.out.println(actSucMsg);
		 
		 if(actSucMsg.contains(orgName)) {
			 System.out.println("org is created successfully == PASS");
		   }
		 else {
			 System.out.println("org is not created == FAIL");
		   }
	}
	
	@Test(groups={"Smoke","Regression"})
	public void createOrgwithIndustTest() throws Throwable {
		
		 String orgName= eLib.getDataFromExcel("org", 1, 2) +"_"+ jLib.getRandom();
		 String Industry= eLib.getDataFromExcel("org",4 , 3);
		 /* navigate to organization*/
		 HomePage hp= new HomePage(driver);
		 hp.getOrganizationlink().click();
		 
		 // navigate to create organization page
		 OrganizationsPage op= new OrganizationsPage(driver);
		 op.getCreateOrgImg().click();

		 //create organization with industry
		 CreateNewOrganizationPage cnop= new CreateNewOrganizationPage(driver);
		 cnop.createOrg(orgName,Industry);
		 
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
	}
	

}
