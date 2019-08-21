package com.myntra.testcase;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.myntra.pageObjects.LoginPage;
import com.myntra.utilities.ReadConfig;
import com.myntra.utilities.ReadExcel;

@Listeners(com.myntra.utilities.ListenerTest.class)

public class TC01_MyntraLogin extends BaseClass{

	
	@Test(dataProvider="testdata")
	public void login(String un, String pwd) throws IOException{
		LoginPage lp = new LoginPage(driver);
		
		lp.setUserName(un);
		logger.info("UserName entered");
		
		lp.setPassword(pwd);
		logger.info("Password Entered");
		
		lp.loginbutton();
		logger.info("Clicked on Login button");
		ReadConfig.takeScreenshot(driver);		
		
		String title = "Online Shopping for Women, Men, Kids Fashion & Lifestyle - Myntra";
		if(title.equals(driver.getTitle())) {
			Assert.assertTrue(true);
			logger.info("Verified the Title Page");
			ReadConfig.takeScreenshot(driver);
			
		}
		else
			Assert.assertFalse(false);
		
	}	
	
	@DataProvider(name="testdata")
	public Object[][] TestDataFeed(){

		String filepath ="./testData.xlsx";
		ReadExcel re = new ReadExcel(filepath);
		int rows = re.getRowCount(0);
		
		Object[][] credentials = new Object[rows][2];
		
		for(int i=0;i<rows;i++) {
			credentials[i][0] = re.getData(0, i, 0);
			credentials[i][1] = re.getData(0, i, 1);
		}
		
		return credentials;
		
		
	}
	
}
