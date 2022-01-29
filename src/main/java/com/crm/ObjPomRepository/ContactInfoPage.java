package com.crm.ObjPomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
	public ContactInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//span[@class='dvHeaderText']")
	private WebElement consucheaderMsg;

	public WebElement getConsucheaderMsg() {
		return consucheaderMsg;
	}
}
	
	
