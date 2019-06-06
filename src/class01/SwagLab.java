package class01;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Method.CommonMethods;

public class SwagLab extends CommonMethods  {

	@BeforeMethod
	public void setUp(){
		setUpDriver("chrome", "https://www.saucedemo.com/index.html");	
		
		
	}
	@Test
	public void loginPro() throws InterruptedException {
		sendText(driver.findElement(By.id("user-name")), "standard_user");
		Thread.sleep(2000);
		sendText(driver.findElement(By.id("password")), "secret_sauce");
		Thread.sleep(2000);
		clickRadiAndChechk(driver.findElement(By.className("btn_action")));
		Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id=\"inventory_filter_container\"]/div")).isDisplayed();
		
	}
	@AfterMethod
	public void close() {
		driver.close();
	}
}
