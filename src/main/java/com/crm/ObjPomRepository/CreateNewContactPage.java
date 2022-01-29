package com.crm.ObjPomRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class CreateNewContactPage extends WebDriverUtility{
	WebDriver driver=null;
	public CreateNewContactPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getLastName() {
		return lastnname;
	}

	@FindBy(name="lastname")
	private WebElement lastnname;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savebtn;
	
	/*@FindBy(xpath="//input[@title='Select']")
	private WebElement orgLookUpImg*/
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img")
	private WebElement orgLookUpImg;
	
	
	public void createCont(String lastNAme) {
		lastnname.sendKeys(lastNAme);
		savebtn.click();
	}
	
	/**
	 * used to create new contact with orgName
	 * @param driver
	 * @param orgName
	 * @param lastNAme
	 */
	public void createCont(String orgName,String lastNAme) {
		lastnname.sendKeys(lastNAme);
		orgLookUpImg.click();
		switchToWindow(driver,"Accounts&action");
		OrganizationsPage op = new OrganizationsPage(driver);
		op.getSearchedt().sendKeys(orgName);
		op.getSearchbtn().click();
		driver.findElement(By.xpath("//a[.='"+orgName+"']")).click();
		switchToWindow(driver,"Contacts&action");
		savebtn.click();
	}

}
