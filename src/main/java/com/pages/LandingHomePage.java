package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;

public class LandingHomePage extends TestBase{
	
	//page factory || object repository
	@FindBy(xpath ="//div[contains(text(),'Shanmugasundaram Somasundaram')]")
	WebElement Login_With_User_Name ;
	
	@FindBy(xpath ="//span[text()='Digital Service Exchange (DSE)']")
	WebElement DSE_Menu_Link ;
	
	@FindBy(xpath = "//span[text()='Create Ticket']")
	WebElement Create_Ticket_Link;
	
	@FindBy(xpath = "//span[text()='View Ticket']")
	WebElement View_Ticket_Link;
	
	@FindBy(xpath = "//span[text()='Employee']")
	WebElement Switching_Role;
	
	@FindBy(xpath = "//span[text()='L3 Support SSC Portal Login Issues Employee']")
	WebElement Change_Role;
	
	//Initializing page object
	public LandingHomePage() {
		PageFactory.initElements(driver, this);//this means current class object
	}
	
	public String verifyLoginPageTitle () {
		return driver.getTitle();
	}
	
	public String printUrl() {
		return driver.getCurrentUrl();	
	}
	
	public boolean verifyUserName() {
		return Login_With_User_Name.isDisplayed();
	}
	
	public CreateTicketPage ClickOnDigitalServiceExchangeToCreateTicket() {
		DSE_Menu_Link.click();
		Create_Ticket_Link.click();
		return new CreateTicketPage();
	}
	
	public ViewTicketPage ClickOnDigitalServiceExchangeToViewTicket() {
		DSE_Menu_Link.click();
		View_Ticket_Link.click();
		return new ViewTicketPage();
	}
	
	public void changeRole() {
		Actions action = new Actions(driver);
		action.moveToElement(Change_Role).build().perform();
		Switching_Role.click();
	}
	
	
	

}
