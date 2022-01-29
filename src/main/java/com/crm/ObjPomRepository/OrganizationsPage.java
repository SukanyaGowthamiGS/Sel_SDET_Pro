package com.crm.ObjPomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
	
	public OrganizationsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement createOrgImg;
	
	@FindBy(name="search_text")
	private WebElement searchedt;
	
    @FindBy(name="search")
	private WebElement searchbtn;

	public WebElement getCreateOrgImg() {
		return createOrgImg;
	}
	
	public WebElement getSearchedt() {
		return searchedt;
	}

	public WebElement getSearchbtn() {
		return searchbtn;
	}
	

	

}
