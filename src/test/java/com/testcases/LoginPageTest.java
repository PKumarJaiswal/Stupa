package com.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.pages.LandingHomePage;
import com.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	LandingHomePage landingHomePage;
	
	
	public LoginPageTest() {
		super();// super class Constructor called by super keyword
	}
	
	@BeforeMethod
	public void setUp() {
		initializeDriver();
		//loginUrl();
		loginWithToken();
		loginPage = new LoginPage();
		// Thread.currentThread() return current method name 
        // at 1st index in Stack Trace 
		System.out.println("Name of current method: "+Thread.currentThread().getStackTrace()[1].getMethodName()); 
	}
	
	@Test(priority=1)
	public void loginPageTitle() {
		System.out.println("Name of current method: "+Thread.currentThread().getStackTrace()[1].getMethodName()); 
		String title = loginPage.verifyLoginPageTitle();
		Assert.assertEquals(title, "IFix", "Check The Title");
	}
	
	@Test(priority=2)
	public void formheading() {
		System.out.println("Name of current method: "+Thread.currentThread().getStackTrace()[1].getMethodName()); 
		boolean flagHeading = loginPage.verifyFormHead();
		Assert.assertTrue(flagHeading, "check the Form Heading");
	}
	
	@Test(priority=3)
	public void loginTest() {
		System.out.println("Name of current method: "+Thread.currentThread().getStackTrace()[1].getMethodName()); 
		landingHomePage = loginPage.login(prop.getProperty("userid"), prop.getProperty("clientcode"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void closeBrowser() {
		System.out.println("Name of current method: "+Thread.currentThread().getStackTrace()[1].getMethodName()); 
		driver.quit();
	}

}
