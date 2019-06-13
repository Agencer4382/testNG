package com.Class02;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;

import Method.CommonMethods;

public class PriorityExample extends CommonMethods {
	
	@BeforeClass
	public void setUp() {
		setUpDriver("chrome", "https://www.saucedemo.com/");
		boolean swagLabs=driver.findElement(By.xpath("/html/body/div[1]")).isDisplayed();
		if(swagLabs==true) {
			System.out.println("Got the title");
		}else {
			System.out.println("Wrong title");
		}
	}
	@Test
	public  void  login() {
		sendText(driver.findElement(By.id("user-name")), "standard_user");
		sendText(driver.findElement(By.id("password")), "secret_sauce");
		clickRadiAndChechk(driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/input[3]")));
	}
	@Test
	public void mainPage() {
		String actual=driver.findElement(By.xpath("//*[@id=\"inventory_filter_container\"]/div")).getText();
		String expected="Products";
		if(expected.equals(actual)) {
			System.out.println("Actual text");
		}else {
			System.out.println("No match");
		}
	}
	@AfterClass
	public void closePage() {
		driver.close();
	}

}
