package com.myntra.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(name="email")
	@CacheLookup
	WebElement userName;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement password;
	
	@FindBy(xpath="//button[contains(@class,'login-login-button') and text()='Log in']")
	@CacheLookup
	WebElement btn;
	
	public void setUserName(String un) {
		userName.sendKeys(un);
	}
	
	public void setPassword(String pwd) {
		password.sendKeys(pwd);
	}
	
	public void loginbutton() {
		btn.click();
		
	}
}
