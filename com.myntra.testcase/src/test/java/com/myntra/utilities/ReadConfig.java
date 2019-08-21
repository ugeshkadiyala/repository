package com.myntra.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ReadConfig {

	Properties pro;
	
	
	File src = new File("./Configuration/configuration.properties");
	public ReadConfig() {
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public String getAppURL() {
		String url = pro.getProperty("baseURL");
		return url;
	}
	
	public String getUserName() {
		String un = pro.getProperty("username");
		return un;
	}
	
	public String getPassword() {
		String pwd = pro.getProperty("password");
		return pwd;
	}
	
	public String getChromePath() {
		String cp = pro.getProperty("chromepath");
		return cp;
	}
	
	public static void takeScreenshot(WebDriver driver) throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("./Screenshots/screenshot.png"), true);	
	}
}
