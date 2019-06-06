package taskHW;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Method.CommonMethods;

public class Task1LoginHRM extends CommonMethods {
	
	@BeforeClass
	public void setUp() {
		setUpDriver("chrome", "https://opensource-demo.orangehrmlive.com/");
	}
	@Test
	public void login() throws InterruptedException {
	sendText(driver.findElement(By.id("txtUsername")),"Admin");	
	Thread.sleep(2000);
	sendText(driver.findElement(By.id("txtPassword")), "admin123");
	Thread.sleep(2000);
	clickRadiAndChechk(driver.findElement(By.id("btnLogin")));
	}
   @AfterClass
   public void close() {
	  // driver.quit();
   }
	

}
