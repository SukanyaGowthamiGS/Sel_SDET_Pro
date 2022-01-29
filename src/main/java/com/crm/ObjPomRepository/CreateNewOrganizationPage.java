package com.crm.ObjPomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class CreateNewOrganizationPage extends WebDriverUtility{
	
	public CreateNewOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="accountname")
	private WebElement orgName;
	
	@FindBy(name="industry")
	private WebElement industries;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savebtn;
	

	public WebElement getIndustries() {
		return industries;
	}
	
	public void createOrg(String OrgNAme)
	{
		orgName.sendKeys(OrgNAme);
		savebtn.click();
	}
	
	public void createOrg(String OrgNAme, String industry)
	{
		select(getIndustries(),industry);
		orgName.sendKeys(OrgNAme);
		savebtn.click();
	}
}
