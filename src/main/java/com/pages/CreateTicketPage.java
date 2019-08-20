package com.pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.base.TestBase;

public class CreateTicketPage extends TestBase{
	
	public static String getTicketNumber;
	
	//page factory || object repository
	@FindBy(xpath = "//span[text()='L3 Support SSC Portal Login Issues Employee']")
	//@CacheLookup // store the xpath inside the cache memory when 
	//the page got refresh the cache memory may destroyed or may not be destroyed . 
	//but when the element won't repeat the page then u can use it
	WebElement Change_Role;
	
	@FindBy(xpath = "//span[text()='Employee']")
	WebElement Switching_Role;
	
	@FindBy(xpath = "//input[@placeholder='Ticket description']")
	WebElement Ticket_Description;
	
	@FindBy(xpath = "//textarea[@placeholder='Brief description']")
	WebElement Brief_Description;
	
	@FindBy(xpath = "//button[text()='Create ']")
	WebElement Create_btn;
	
	@FindBy(xpath = "//select[@id='ticket_3']")
	WebElement Category_Function;
	
	@FindBy(xpath = "//select[@id='ticket_4']")
	WebElement Category_Module;
	
	@FindBy(xpath = "//select[@id='ticket_5']")
	WebElement Category_Sub_Module;
	
	
	public CreateTicketPage() {
		PageFactory.initElements(driver, this);//this means current class object
	}
	
	public boolean verifyCurrentGroup() {
		return Change_Role.isDisplayed();
	}
	
//	public void changeRole() {
//		Actions action = new Actions(driver);
//		action.moveToElement(Change_Role).build().perform();
//		Switching_Role.click();
//	}
	
	public ViewTicketPage ticketCreation(String function,String module, String subModule, String ticketDes, String briefDes) {
		
		//or you can use Select fName = new Select(Category_Function) , sometimes you've to use below the line
		Select fName = new Select(driver.findElement(By.xpath("//select[@id='ticket_3']"))); 
		//fName.selectByVisibleText("SSC PORTAL LOGIN ISSUES");
		fName.selectByVisibleText(function);
		
		Select moName = new Select(driver.findElement(By.xpath("//select[@id='ticket_4']"))); 
		moName.selectByVisibleText(module);
		
		Select sbmoName = new Select(driver.findElement(By.xpath("//select[@id='ticket_5']"))); 
		sbmoName.selectByVisibleText(subModule);
		
		
		Ticket_Description.sendKeys(ticketDes);
		Brief_Description.sendKeys(briefDes);
		
		// using javascript for scroll
//		JavascriptExecutor jse = (JavascriptExecutor) driver;
//		WebElement btnElement = Create_btn;
//		jse.executeScript("arguments[0].scrollIntoView(true);", btnElement);
//		btnElement.click();
		
		Create_btn.click();
		getTicketNumber =driver.findElement(By.className("notifier-notification")).getText() ;
		System.out.println("\n"+getTicketNumber);
		return new ViewTicketPage();
	}
	
	public String currentDate() {
		/*  Create object of SimpleDateFormat class and decide the format     */
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH:mm:ss");
		/*  get current date time with Date()    */
		Date date = new Date();
		/*  Now format the date */
		 String IST = dateFormat.format(date);
		 return IST;
	}
	
}
