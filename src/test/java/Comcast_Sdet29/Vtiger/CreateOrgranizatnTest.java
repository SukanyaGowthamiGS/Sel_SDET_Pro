package Comcast_Sdet29.Vtiger;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
//import org.testng.asserts.SoftAssert;
import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjPomRepository.CreateNewOrganizationPage;
import com.crm.ObjPomRepository.HomePage;
import com.crm.ObjPomRepository.OrganizationInfoPage;
import com.crm.ObjPomRepository.OrganizationsPage;

@Listeners(com.crm.GenericLibrary.ListnerImpClass.class)
public class CreateOrgranizatnTest extends BaseClass {
	
	@Test(groups="Smoke",retryAnalyzer= com.crm.GenericLibrary.RetryImpClass.class)
	public void createOrgTest() throws Throwable {
		//read test data
		 String orgName= eLib.getDataFromExcel("org", 1, 2) +"_"+ jLib.getRandom();
		 
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
		 Assert.assertEquals(actSucMsg.contains(orgName), true);
		 System.out.println("org is created==>PASS");
		 
		 /*SoftAssert soft= new SoftAssert();
		 soft.assertTrue(actSucMsg.contains(orgName));
		 System.out.println("*********PASS**************");
		 System.out.println("**********FAIL*********");
		 soft.assertEquals(actSucMsg.trim(), orgName);
	     soft.assertAll();*/
		 
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
         wLib.waitForElementVisibility(driver,opp.getSuccesfullMsg());
		 
		 String actOrgMsg =opp.getSuccesfullMsg().getText();
		 String actSucMsg =opp.getIndustryMsg().getText();
		 
		 /*System.out.println(actSucMsg)
		 Assert.assertTrue(actOrgMsg.contains(orgName));
		 Assert.assertTrue(actSucMsg.contains(Industry));
		 
		 Assert.assertEquals(actOrgMsg.trim(), orgName);
		 System.out.println("****org created***");
		 Assert.assertEquals(actSucMsg.trim(), Industry);
		 //soft.assertAll();*/
		 
		 Assert.assertEquals(actOrgMsg.contains(orgName), true);
		 System.out.println("org is created");
		 Assert.assertEquals(actSucMsg.contains(Industry), true);
		 System.out.println("org with industry is created==>PASS");
	}
	

}
