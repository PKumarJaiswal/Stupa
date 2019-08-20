package com.utility;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.base.TestBase;
import com.google.common.base.Function;

public class TestUtil extends TestBase{
	
	public static String TESTDATA_SHEET_PATH = "C:\\Users\\ASUS\\eclipse-workspace\\Hybrid\\src\\main\\java\\com\\testdata\\Excel.xlsx";

	static Workbook book;
	static Sheet sheet;
	static JavascriptExecutor js;
	
	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (Exception ex) {
			ex.printStackTrace();
			ex.getMessage();
		} 
		
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
	}

	public static void takeScreenshotAtEndOfTest() {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		try {
			FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
	public static void usingFluentWait(){
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
      		  //.pollingEvery(1, TimeUnit.SECONDS)
      		  //.withTimeout(10, TimeUnit.SECONDS)
      		  .pollingEvery(Duration.ofMillis(6000))
      		  .withTimeout(Duration.ofSeconds(10000))
      		  .ignoring(NoSuchElementException.class);
                 
        WebElement element = wait.until(new Function<WebDriver, WebElement>() {	               
      	  public WebElement apply(WebDriver arg0) {
      		  WebElement ele = arg0.findElement(By.xpath("//p[@id='demo']"));
                if (ele.getAttribute("innerHTML").equalsIgnoreCase("WebDriver")) {
                      System.out.println("Value is >>> " + ele.getAttribute("innerHTML"));
                      return ele;
                }
                else {
                  System.out.println("Value is >>> " + ele.getAttribute("innerHTML"));
                  return null;
                }
      	  }
        });
        System.out.println("Final visible status is >>>>> " + element.isDisplayed());
	}

}
