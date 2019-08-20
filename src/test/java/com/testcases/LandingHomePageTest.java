package com.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.pages.CreateTicketPage;
import com.pages.LandingHomePage;
import com.pages.LoginPage;

public class LandingHomePageTest extends TestBase{
	
	LoginPage loginPage;
	LandingHomePage landingHomePage;
	CreateTicketPage createTicket;
	
	public LandingHomePageTest() {
		super();// super class Constructor called by super keyword
	}
	
	@BeforeMethod
	public void setUp() {
		initializeDriver();
		loginWithToken();
		createTicket = new CreateTicketPage();
		loginPage = new LoginPage();
		//landingHomePage = loginPage.login(prop.getProperty("userid1"), prop.getProperty("clientcode"), prop.getProperty("password"));
		landingHomePage = loginPage.loginWithToken(
				prop.getProperty("clientid"), 
				prop.getProperty("userid1"), 
				prop.getProperty("ittid"),
				prop.getProperty("icat1"),
				prop.getProperty("icat2"),
				prop.getProperty("pttid"),
				prop.getProperty("pcat1"),
				prop.getProperty("pcat2"));
		 
		System.out.println("Name of current method: "+Thread.currentThread().getStackTrace()[1].getMethodName()); 
	}
	
	@Test(priority=1)
	public void loginPageTitle() {
		System.out.println("Name of current method: "+Thread.currentThread().getStackTrace()[1].getMethodName());
		String title = landingHomePage.verifyLoginPageTitle();
		Assert.assertEquals(title, "IFix", "Check The Title");
	}
	
	@Test(priority=2)
	public void userName() {
		System.out.println("Name of current method: "+Thread.currentThread().getStackTrace()[1].getMethodName());
		boolean flagHeading = landingHomePage.verifyUserName();
		Assert.assertTrue(flagHeading, "check the Form Heading");
	}
	
	@Test(priority=3)
	public void loginTest() {
		System.out.println("Name of current method: "+Thread.currentThread().getStackTrace()[1].getMethodName());
		String getUrl = landingHomePage.printUrl();
		System.out.println("URL: "+getUrl);
	}
	
	@Test(priority=4)
	public void verifyCreateTicketLink() {
		System.out.println("Name of current method: "+Thread.currentThread().getStackTrace()[1].getMethodName());
		createTicket = landingHomePage.ClickOnDigitalServiceExchangeToCreateTicket();
		String getUrl = landingHomePage.printUrl();
		System.out.println("Create Ticket URL: "+getUrl);	
	}
	
	@AfterMethod
	public void closeBrowser() {
		System.out.println("Name of current method: "+Thread.currentThread().getStackTrace()[1].getMethodName());
		driver.quit();
	}

}
