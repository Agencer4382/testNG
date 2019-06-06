package taskHW;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Method.CommonMethods;

public class Task3EmployeeDetails extends CommonMethods {
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
	public void listEmployee() throws InterruptedException {
		clickRadiAndChechk(driver.findElement(By.id("menu_pim_viewPimModule")));
		Thread.sleep(2000);
		clickRadiAndChechk(driver.findElement(By.xpath("//a[text()='Employee List']")));
	}
	@Test
	public void verifyEmpDetails() throws InterruptedException {
		List<WebElement>row=driver.findElements(By.xpath("//*[@id=\"resultTable\"]/tbody/tr"));
		System.out.println("Table row size : "+row.size());
		
		String expectedValue="0082";
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
