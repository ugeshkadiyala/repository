package com.myntra.testcase;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.myntra.utilities.ReadConfig;


public class BaseClass {
	ReadConfig rc = new ReadConfig();
	
	public String url = rc.getAppURL();
	//public String un = rc.getUserName();
	//public String pwd = rc.getPassword();
	
	public WebDriver driver;
	public static Logger logger;
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", rc.getChromePath());
		driver = new ChromeDriver();
		
		logger = Logger.getLogger("Myntra Store");
		PropertyConfigurator.configure("log4j.properties");
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(5000);
		
		WebElement w = driver.findElement(By.xpath("//span[contains(@class, 'desktop-userTitle') and text() = 'Profile']"));
		WebElement wb = driver.findElement(By.xpath("//a[contains(text(), 'log in')]"));
		logger.info("User clicked on Profile icon");
		
		Actions ac = new Actions(driver);
		ac.moveToElement(w).click(wb).build().perform();
		logger.info("User clicked on Login button");
		
	}


	@AfterMethod
	public void tearDown() {
		driver.quit();
		logger.info("Application Closed successfully");
	}
}
