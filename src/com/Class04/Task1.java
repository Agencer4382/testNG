package com.Class04;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Method.CommonMethods;

public class Task1 extends CommonMethods {
	 @BeforeMethod(alwaysRun =true, groups ="Regression")
	    public void setUP() {
	        setUpDriver("chrome", "https://www.saucedemo.com/");
	       
	    }
	 @Test(groups ="Smoke")
		public  void  login() {
			sendText(driver.findElement(By.id("user-name")), "standard_user");
			sendText(driver.findElement(By.id("password")), "secret_sauce");
			clickRadiAndChechk(driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/input[3]")));
		}
	 @Test(groups ="Regression")
		public  void  login1() {
			sendText(driver.findElement(By.id("user-name")), "problem_user");
			sendText(driver.findElement(By.id("password")), "secret_sauce");
			clickRadiAndChechk(driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/input[3]")));
		}
	 @AfterMethod(alwaysRun = true, groups ="Regression")
	    public void closeBr() {
	        driver.close();
	    }

}
