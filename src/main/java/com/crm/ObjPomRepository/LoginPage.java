package com.crm.ObjPomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//Rule1:create separate class for every page and class name should be same as page name
public class LoginPage {
	
		
		//Rule3:execute all the elements & initialize elements by PageFactory.initElement
		public  LoginPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
			
		}

		//Rule2:identify all the elements using @Findby,@FindAll
		@FindBy(name="user_name")
		private WebElement userName;
		
		@FindBy(name="user_password")
		private WebElement userPwd;
		
		@FindAll({@FindBy(id="submitButton"),@FindBy(xpath="//input[@id='submitButton']")})
		private WebElement loginBtn;

		//Rule4:Declare all elements as private and provide getters method,business method(Utilization)

		public WebElement getUserName() {
			return userName;
		}

		public WebElement getUserPwd() {
			return userPwd;
		}

		public WebElement getLoginBtn() {
			return loginBtn;
		}
		
		public void loginToApp(String username,String password) {
			//step1: login
			userName.sendKeys(username);
			userPwd.sendKeys(password);
			loginBtn.click();
			
		}
		
		
	}


