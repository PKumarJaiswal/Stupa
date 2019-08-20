package com.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.pages.CreateTicketPage;
import com.pages.LandingHomePage;
import com.pages.LoginPage;
import com.pages.ViewTicketPage;
import com.utility.TestUtil;

public class CreateTicketPageTest extends TestBase{
	
	LoginPage loginPage;
	LandingHomePage landingHomePage;
	CreateTicketPage createTicket;
	ViewTicketPage viewTicket;
	String sheetName = "Create";
	
	public CreateTicketPageTest() {
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
		createTicket = landingHomePage.ClickOnDigitalServiceExchangeToCreateTicket();
		
		System.out.println("Name of current method: "+Thread.currentThread().getStackTrace()[1].getMethodName()); 
	}
	
	@DataProvider 
	public Object[][] getDataFromExcelFile() {
		Object data[][]  = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority = 1, dataProvider = "getDataFromExcelFile")
	public void validateCreate(String function,String module, String submodule, String ticketdescription, String briefdescription) {
		System.out.println("Name of current method: "+Thread.currentThread().getStackTrace()[1].getMethodName());
		//viewTicket = createTicket.ticketCreation(prop.getProperty("ticketdes"), prop.getProperty("berifdes"));
		
		String senwddate = briefdescription+" "+createTicket.currentDate()+" "+function;
		System.out.println("Content: "+senwddate);
		
		landingHomePage.changeRole();
		createTicket.ticketCreation(function, module, submodule, ticketdescription, briefdescription);
	}
	
	
	@AfterMethod
	public void closeBrowser() {
		System.out.println("Name of current method: "+Thread.currentThread().getStackTrace()[1].getMethodName());
		driver.quit();
	}

}