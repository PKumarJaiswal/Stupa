package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;

public class LoginPage extends TestBase{
	
	//page factory || object repository
	@FindBy(xpath ="//*[@placeholder='Enter User Id']")
	WebElement Enter_User_Id ;
	
	@FindBy(xpath ="//*[@placeholder='Enter Client Code']")
	WebElement Enter_Client_Code ;
	
	@FindBy(xpath ="//*[@placeholder='Password']")
	WebElement Password ;
	
	@FindBy(xpath = "//*[text()='Log In']")
	WebElement Log_In_Btn;
	
	@FindBy(xpath = "//*[@class=\"join\"]")
	WebElement Form_Head;
	
	
	/* ::::::::::::::::::::::: Token Login :::::::::::::::::::*/
	
	@FindBy(xpath = "//input[@placeholder='Enter Client Id']")
	WebElement Enter_Client_Id;
	
	@FindBy(xpath = "//input[@placeholder='Enter Incident Ticket Type Id ']")
	WebElement Enter_Incident_Ticket_Type_Id ;
	
	@FindBy(xpath = "//input[@placeholder='Enter Category 1 for Incident ticket type ']")
	WebElement Enter_Category_1_for_Incident_ticket_type ;
	
	@FindBy(xpath = "//input[@placeholder='Enter Category 2 for Incident ticket type ']")
	WebElement Enter_Category_2_for_Incident_ticket_type;
	
	@FindBy(xpath = "//input[@placeholder='Enter Problem Ticket Type Id']")
	WebElement Enter_Problem_Ticket_Type_Id;
	
	@FindBy(xpath = "//input[@placeholder='Enter Category 1 for Problem ticket type  ']")
	WebElement Enter_Category_1_for_Problem_ticket_type  ;
	
	@FindBy(xpath = "//input[@placeholder='Enter Category 2 for Problem ticket type  ']")
	WebElement Enter_Category_2_for_Problem_ticket_type ;
	
//	@FindBy(xpath = "//input[@placeholder='Enter Source Type ']")
//	WebElement Enter_Source_Type;
	
	@FindBy(xpath = "//button[text()='Create Ticket']")
	WebElement Create_Ticket_Btn;
	
	//Initializing page object
	public LoginPage() {
		PageFactory.initElements(driver, this);//this means current class object
	}
	
	//this method should be in Shortmethod.java 
	public String verifyLoginPageTitle () {
		return driver.getTitle();
	}
	
	public boolean verifyFormHead () {
		return Form_Head.isDisplayed();
	}
	
	public LandingHomePage login(String userId, String clientCode, String pwd) {
		Enter_User_Id.sendKeys(userId);
		Enter_Client_Code.sendKeys(clientCode);
		Password.sendKeys(pwd);
		Log_In_Btn.click();
		return new LandingHomePage();
		
		
	}

	public LandingHomePage loginWithToken(
			String clientId, 
			String userId, 
			String inciId, 
			String catOneInci,
			String catTwoInci,
			String prbId, 
			String catOnePrb,
			String catTwoPrb) {
		
		boolean elementDer = Enter_Client_Id.isDisplayed();
		if(elementDer = true) {
			System.out.println("Element is Found: "+elementDer);
		}else{
			driver.navigate().refresh();
		}
		
		Enter_Client_Id.clear();
		Enter_Client_Id.sendKeys(clientId);
		
		Enter_User_Id.clear();
		Enter_User_Id.sendKeys(userId);
		
		Enter_Incident_Ticket_Type_Id.clear();
		Enter_Incident_Ticket_Type_Id.sendKeys(inciId);
		
		Enter_Category_1_for_Incident_ticket_type.clear();
		Enter_Category_1_for_Incident_ticket_type.sendKeys(catOneInci);
		
		Enter_Category_2_for_Incident_ticket_type.clear();
		Enter_Category_2_for_Incident_ticket_type.sendKeys(catTwoInci);
		
		Enter_Problem_Ticket_Type_Id.clear();
		Enter_Problem_Ticket_Type_Id.sendKeys(prbId);
		
		Enter_Category_1_for_Problem_ticket_type.clear();
		Enter_Category_1_for_Problem_ticket_type.sendKeys(catOnePrb);
		
		Enter_Category_2_for_Problem_ticket_type.clear();
		Enter_Category_2_for_Problem_ticket_type.sendKeys(catTwoPrb);
		
		Create_Ticket_Btn.click();
		return new LandingHomePage();
		
		
	}
	

}