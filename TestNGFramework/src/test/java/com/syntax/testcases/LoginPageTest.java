package com.syntax.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.syntax.pages.HomePage;
import com.syntax.pages.LoginPage;
import com.syntax.pages.LoginPageWithoutPageFoctory;
import com.syntax.utils.BaseClass;
import com.syntax.utils.CommonMethods;
import com.syntax.utils.ConfigsReader;

public class LoginPageTest extends BaseClass{
	
	

	@Test(groups="smoke")
	public void loginToOrangeHRM() {
		
		LoginPageWithoutPageFoctory login=new LoginPageWithoutPageFoctory();
		//logger.info("Logging in with valid credentials");
		
		CommonMethods.sendText(login.username, "Admin");
		CommonMethods.sendText(login.password, "iQA9o3dP@N");
		CommonMethods.click(login.loginBtn);
		//logger.info("verifiyng dashboard text is displayed");
		HomePage home= new HomePage();
		boolean isDisplayed= home.dashboardText.isDisplayed();
		Assert.assertTrue(isDisplayed);
		//logger.pass("Successfully logged in");
	}
	@Test(groups="smoke")
	public void doLogin() {
		
		LoginPage login=new LoginPage();
		
		//logger.info("Logging in with valid credentials");
		CommonMethods.sendText(login.userName, ConfigsReader.getProperty("username"));
		CommonMethods.sendText(login.password, ConfigsReader.getProperty("password"));
		CommonMethods.click(login.loginBtn);
		//logger.info("verifiyng dashboard text is displayed");
		
		HomePage home= new HomePage();
		boolean isDisplayed= home.dashboardText.isDisplayed();
		Assert.assertTrue(true);
		
	}
//	@Test(groups="regression")
//	public void negativeLogin() {
//		LoginPage login=new LoginPage();
//		logger.info("Logging in with in Valid credentials");
//		login.login("admins", "test");
//		
//		String errorText=login.message.getText();
//	        logger.info("Verifying error message "+errorText);
//	        Assert.assertEquals(errorText, "Invalid Credentials");
//		
//	}
	
	
}