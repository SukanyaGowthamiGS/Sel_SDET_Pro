package com.crm.ObjPomRepository;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	    WebDriver driver;
		
		public HomePage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}

		@FindBy(linkText="Organizations")
		private WebElement organizationlink;
		
		@FindBy(linkText="Contacts")
		private WebElement contactslink;

		@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
		private WebElement adminImg;
		
	    @FindBy(linkText="Sign Out")
		private WebElement signoutlink;
		
	    public WebDriver getDriver() {
			return driver;
		}

		public WebElement getOrganizationlink() {
			return organizationlink;
		}

		public WebElement getContactslink() {
			return contactslink;
		}

		public WebElement getAdminImg() {
			return adminImg;
		}

		public WebElement getSignoutlink() {
			return signoutlink;
		}
		
		public void logout() {
			Actions act= new Actions(driver);
			act.moveToElement(adminImg).perform();
			signoutlink.click();
		}



	}



