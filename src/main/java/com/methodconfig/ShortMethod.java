package com.methodconfig;

import java.util.concurrent.TimeUnit;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShortMethod {
	
	public static WebDriver driver;
	
	/*
	 * This method(getElement) using for code reduce
	 * no need to write driver.findElement(By.xpath) 
	*/
	public static WebElement getElement(String xpathExpression) {
		WebDriverWait wait = new WebDriverWait(driver,40);// using web driver until for wait 40 seconds
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathExpression)));//wait until the element is visible
		return driver.findElement(By.xpath(xpathExpression));
	}
	
	public static WebElement getCssElement (String cssSelector) {
		WebDriverWait wait = new WebDriverWait(driver,40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssSelector)));
		return driver.findElement(By.cssSelector(cssSelector));
	}
	
	public static WebElement getId (String id) {
		WebDriverWait wait = new WebDriverWait(driver,40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
		return driver.findElement(By.id(id));
	}
	
	public static WebElement getLinkText (String linkText) {
		WebDriverWait wait = new WebDriverWait(driver,40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(linkText)));
		return driver.findElement(By.linkText(linkText));
	}
	
	public static WebElement getPartialLinkText(String partialLinkText) {
		WebDriverWait wait = new WebDriverWait(driver,40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(partialLinkText)));
		return driver.findElement(By.partialLinkText(partialLinkText));
	}
	
	public static void clickAt(String xpathExpression) {
		getElement(xpathExpression).click();
	}
	
	public static void clickById(String id) {
		getId(id).click();
	}
	
	public static void sendKeysByXpath(String xpathExpression, String input) {
		getElement(xpathExpression).sendKeys(input);
	}
	
	public static void sendKeysById(String id, String input) {
		getId(id).sendKeys(input);
	}
	
	public  Timeouts waitFor(long arg0, TimeUnit arg1) {
		return driver.manage().timeouts().implicitlyWait(arg0, arg1);	
	}
	
	public  Timeouts waitForPageLoad(long arg0, TimeUnit arg1) {
		 return driver.manage().timeouts().pageLoadTimeout(arg0, arg1);	
	}
	
	public void fullScreen() {
		 driver.manage().window().maximize();	
	}
	
	public void deleteCookies() {
		 driver.manage().deleteAllCookies();	
	}
	
	public static String captureTextByXpath(String xpathExpression) {
		return getElement(xpathExpression).getText();	
	}
	
	public static String captureTextById(String id) {
		return getId(id).getText();	
	}
	
	public static String printPreviousData (String xpathExpression) {
		String previousData = captureTextByXpath(xpathExpression);
		System.out.println("Previous Data: \n"+previousData);
		return previousData;
	}
	
	public static String printUpdatedData (String xpathExpression) {
		String updatedData = captureTextByXpath(xpathExpression);
		System.out.println("Updated Data: \n"+updatedData);
		return updatedData;
	}
	
	public static void log(String data) {
		System.out.println(data);	
	}
	
	
	
	

}
