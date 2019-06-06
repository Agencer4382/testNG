package taskHW;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Method.CommonMethods;

public class Task2AddEmployee extends CommonMethods {
	@BeforeClass
	public void login() throws InterruptedException {
		setUpDriver("chrome", "https://opensource-demo.orangehrmlive.com/");
		
			sendText(driver.findElement(By.id("txtUsername")),"Admin");	
			Thread.sleep(2000);
			sendText(driver.findElement(By.id("txtPassword")), "admin123");
			Thread.sleep(2000);
			clickRadiAndChechk(driver.findElement(By.id("btnLogin")));
			}
		
	
	@Test
	public void addEmployee() throws InterruptedException {
		clickRadiAndChechk(driver.findElement(By.id("menu_pim_viewPimModule")));
		Thread.sleep(2000);
		clickRadiAndChechk(driver.findElement(By.id("menu_pim_addEmployee")));
		Thread.sleep(2000);
		sendText(driver.findElement(By.xpath("//*[@id=\"firstName\"]")), "Kevin");
		Thread.sleep(2000);
		sendText(driver.findElement(By.cssSelector("input[id=lastName]")), "KURT");
		Thread.sleep(2000);
		sendText(driver.findElement(By.id("employeeId")), "0082");
		Thread.sleep(2000);
		clickRadiAndChechk(driver.findElement(By.id("chkLogin")));
		Thread.sleep(2000);
		sendText(driver.findElement(By.id("user_name")), "Kevin123");
		Thread.sleep(2000);
		sendText(driver.findElement(By.id("user_password")),"Kurt123Kevin.");
		Thread.sleep(2000);
		sendText(driver.findElement(By.id("re_password")),"Kurt123Kevin.");
		Thread.sleep(2000);
		
		selectValueFromDD(driver.findElement(By.id("status")), "Enabled");
		Thread.sleep(2000);
		clickRadiAndChechk(driver.findElement(By.cssSelector("input[value='Save']")));
		Thread.sleep(2000);
		clickRadiAndChechk(driver.findElement(By.xpath("//a[text()='Employee List']")));
	}
	@Test
	public void verifyEmployee() throws InterruptedException {
		List<WebElement>row=driver.findElements(By.xpath("//*[@id=\"resultTable\"]/tbody/tr"));
		System.out.println("Table row size : "+row.size());
		
		String expectedValue="Kevin";
		for (int i=1; i<=row.size(); i++) {
			String rowText = driver.findElement(By.xpath("//*[@id=\"resultTable\"]/tbody/tr["+i+"]")).getText();
			if(rowText.contains(expectedValue)) {
				driver.findElement(By.xpath("//table[@id=\"resultTable\"]/tbody/tr["+i+"]/td[1]")).click();
				Thread.sleep(2000);
			System.out.println("New employee : "+rowText);
			}
		}
	}
	@AfterClass
	
	public void quite() throws InterruptedException  {
		Thread.sleep(3000);
		driver.quit();
		
		
	}

}
