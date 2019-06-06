package com.Class02;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Method.CommonMethods;

public class Task extends CommonMethods {
	
	@BeforeMethod
	public void setUp(){
		setUpDriver("chrome", "https://opensource-demo.orangehrmlive.com/");
		
	}
	
	@Test
	public void login() throws InterruptedException {
		sendText(driver.findElement(By.cssSelector("input#txtUsername")), "Admin");
		Thread.sleep(2000);
		sendText(driver.findElement(By.cssSelector("input#txtPassword")), "admin123");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input#btnLogin")).click();
	}
	@Test(priority=1)
	public void getTitle() {
		String title=driver.getTitle();
		String exTitle="OrangeHRM";
		if(title.equals(exTitle)) {
			System.out.println("Got the title");
			
		}else {
			System.out.println("Wrong title");
		}
	}
	
	@AfterMethod
	public void close() {
		driver.close();
	}

}
