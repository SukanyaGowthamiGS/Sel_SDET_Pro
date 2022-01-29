package com.crm.ObjPomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {

	public OrganizationInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement succesfullMsg;
	
	@FindBy(xpath="//span[@id='dtlview_Industry']")
	private WebElement IndustryMsg;

	public WebElement getIndustryMsg() {
		return IndustryMsg;
	}

	public WebElement getSuccesfullMsg() {
		return succesfullMsg;
	}
}
