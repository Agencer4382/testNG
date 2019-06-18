package com.syntax.testcases;

import org.testng.annotations.Test;

import com.syntax.lsu.utils.BaseClass;
import com.syntax.lsu.utils.CommonMethods;
import com.syntax.lsu.utils.ConfigReader;
import com.syntax.pages.LoginPage;

public class LoginPageTest extends BaseClass {

	@Test()
	public void doLogin() {

		LoginPage login = new LoginPage();
		
		CommonMethods.sendText(login.username, ConfigReader.getProperty("username"));
		CommonMethods.sendText(login.password, ConfigReader.getProperty("password"));
		CommonMethods.click(login.loginBtn);

	}

}
