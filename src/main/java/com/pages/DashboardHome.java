package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;

public class DashboardHome extends TestBase{
	
	//page factory || object repository
	@FindBy(className ="active")
	WebElement Header_Name_Dash;
	
	@FindBy(id ="drop-button")
	WebElement User_Name;
	
	@FindBy(xpath ="//*[contains(text(),'For Analyst ')]")
	WebElement Action_For_Analyst;
	
	@FindBy(xpath ="//*[contains(text(),'Raised ')]")
	WebElement Request_Raised;
	
	@FindBy(xpath ="//*[contains(text(),'Follow Up ')]")
	WebElement Follow_Up;
	
	@FindBy(xpath ="//*[contains(text(),'User Replied ')]")
	WebElement User_Replied;
	
	@FindBy(xpath = "//*[contains(text(),'Escalated By User ')]")
	WebElement Escalated_By_User;
	
	@FindBy(xpath = "//*[contains(text(),'SLA Alert ')]")
	WebElement SLA_Alert ;
	
	@FindBy(xpath = "//*[contains(text(),'Sr. Mgmt Tickets ')]")
	WebElement Sr_Mgmt_Tickets ;
	
	@FindBy(xpath = "//*[text()='Search Ticket']")
	WebElement Search_Ticket;
	
	@FindBy(xpath = "//*[text()='FAQ']")
	WebElement FAQ;
	
	@FindBy(xpath = "//*[@class='pointer'] | //*[text()='Home']")
	WebElement Click_On_Home;
	
	
	//Initializing page object
	public DashboardHome() {
		PageFactory.initElements(driver, this); //this means current class object
	}
	
	public String verifyDashboard () {
		return Header_Name_Dash.getText();
	}
	
	public String verifyUser () {
		return User_Name.getText();
	}
	
	/*public String verifySupportGroup () {
		return User_Name.getText();
	}*/
	
	public void goToDashboard () {
		Click_On_Home.click();
	}

}
