package com.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.methodconfig.ShortMethod;
import com.utility.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver eventFiringWebDriver;
	public static WebEventListener webEventListener;
	
	 ShortMethod shortMethod;
	
	public TestBase() {
		prop = new Properties();
		String proUrlForLinux = "/home/mantechpc/eclipse-workspace/Hybrid/src/main/java/com/config/config.properties";
		String proUrlForWindow = "C:\\Users\\ASUS\\eclipse-workspace\\Hybrid\\src\\main\\java\\com\\config\\config.properties";
		
		try {
		FileInputStream fis = new FileInputStream(proUrlForWindow);
		prop.load(fis);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	} // Constructor end
	
	public void initializeDriver() {
		String chromePathForLinux = "/home/mantechpc/Desktop/susovan DAS/susovan/Driver/chromedriver";
		String chromePathForWindow = "E:\\Desktop\\Testing\\Driver\\chromedriver.exe";
		
		String firefoxPathForLinux = "/home/mantechpc/Desktop/susovan DAS/susovan/Driver/geckodriver";
		String firefoxPathForWindow = "E:\\Desktop\\Testing\\Driver\\geckodriver.exe";
		
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", chromePathForWindow);
			if(prop.getProperty("headless").equals("yes")) {
				//headless mode
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless");
				driver = new ChromeDriver(options);
			}else {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("user-data-dir=D:\\Use It\\Chrome");
				DesiredCapabilities capabilities = DesiredCapabilities.chrome();
				capabilities.setCapability(ChromeOptions.CAPABILITY, options);
				driver = new ChromeDriver(capabilities);
//				driver = new ChromeDriver();
				driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			}
		} else if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", firefoxPathForWindow);
				driver = new FirefoxDriver();
			
		}
		
		eventFiringWebDriver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		webEventListener = new WebEventListener();
		eventFiringWebDriver.register(webEventListener);
		driver = eventFiringWebDriver;
		
//		shortMethod.fullScreen();
//		shortMethod.waitForPageLoad(10, TimeUnit.SECONDS);
//		shortMethod.waitFor(10, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
//		if (prop.getProperty("url").isEmpty()||prop.getProperty("url").equals("NA") ) {
//			String LoginUrl = "http://52.25.76.231:9000/#/";
//			String generateToken = "http://52.25.76.231:9000/#/generateToken";
//			driver.get(LoginUrl);
//		}else {
//			driver.get(prop.getProperty("url"));
//		}
		
		
		
	} // initializeDriver End
	
	public void loginUrl() {
		if (prop.getProperty("productionURL").isEmpty()||prop.getProperty("productionURL").equals("NA") ) {
			String LoginUrl = "http://52.25.76.231:9000/#/";
			String uat2URL = "http://uat2.ifixcloud.co/#/";
			String productionURL = "http://lntssc.ifixcloud.co/#/";
			driver.get(productionURL);
		}else {
			driver.get(prop.getProperty("productionURL"));
		}
	}
	
	
	public void loginWithToken() {
		if (prop.getProperty("productionTokenLogin").isEmpty()||prop.getProperty("productionTokenLogin").equals("NA") ) {
			String stagingTokenLogin = "http://52.25.76.231:9000/#/tokenLogin";
			String uat2TokenLogin = "http://uat2.ifixcloud.co/#/tokenLogin";
			String productionTokenLogin = "http://lntssc.ifixcloud.co/#/tokenLogin";
			driver.get(uat2TokenLogin);
		}else {
			driver.get(prop.getProperty("uat2TokenLogin"));
		}
	}
	


}
