package com.Class05;



import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Method.CommonMethods;

public class TaskDataProvider extends CommonMethods {
	
	@Parameters({"browser", "url","username","password"})
	@BeforeClass(alwaysRun=true)
	public void setUp(String browser,String url, String username,String password) {
		setUpDriver(browser, url);
		driver.findElement(By.xpath("//input[contains(@id,'username')]")).sendKeys(username);
		driver.findElement(By.xpath("//input[contains(@id,'password')]")).sendKeys(password);
		clickRadiAndChechk(driver.findElement(By.xpath("//input[contains(@id,'login_button')]")));
		Assert.assertEquals(driver.findElement(By.xpath("//h1[text()='Web Orders']")).isDisplayed(),true);
	}
	@DataProvider()
	public Object[][] setUpData(){
		Object[][] data= new Object[2][8];
		
		data[0][0]="MyMoney";
		data[0][1]="5";
		data[0][2]="Kevin KURT";
		data[0][3]="30 Loop Ave.";
		data[0][4]="JAVA";
		data[0][5]="07015";
		data[0][6]="1234569789789456";
		data[0][7]="10/25";
		
		data[1][0]="ScreenSaver";
		data[1][1]="3";
		data[1][2]="Will Smith";
		data[1][3]="20 For Ave.";
		data[1][4]="TestNG";
		data[1][5]="07015";
		data[1][6]="1234569789789456";
		data[1][7]="10/23";
		
		return data;
		
	}
	@Test(dataProvider="setUpData", priority=1)
	public void getData(String product,String quantity, String name, String street, String city, String zip, String cardNum, String date) throws InterruptedException {
		
		clickRadiAndChechk(driver.findElement(By.xpath("//a[text()='Order']")));
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_ddlProduct\"]")).sendKeys(product);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtQuantity']")).sendKeys(quantity);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_txtName\"]")).sendKeys(name);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_TextBox2\"]")).sendKeys(street);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_TextBox3\"]")).sendKeys(city);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_TextBox5\"]")).sendKeys(zip);
		Thread.sleep(1000);
		clickRadiAndChechk(driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_cardList_0\"]")));
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_TextBox6\"]")).sendKeys(cardNum);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_TextBox1\"]")).sendKeys(date);
		Thread.sleep(1000);
		clickRadiAndChechk(driver.findElement(By.xpath("//a[text()='Process']")));
		Thread.sleep(1000);
		clickRadiAndChechk(driver.findElement(By.xpath("//a[text()='View all orders']")));
		
		
	}
	@Test(priority=2)
    public void changeAdress() throws InterruptedException { 
		WebElement orderDetails1 = driver
				.findElement(By.xpath("//*[@id=\"ctl00_MainContent_orderGrid\"]/tbody/tr[3]/td[13]/input"));
		orderDetails1.click();
		System.out.println("Order details edit.");

		sendText(driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_TextBox2\"]")), "25 Loop Avenue");
		Thread.sleep(2000);
		clickRadiAndChechk(driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_UpdateButton\"]")));
		System.out.println("Street adress is updated.");
		Thread.sleep(2000);
		clickRadiAndChechk(driver.findElement(By.xpath("//a[text()='View all orders']")));
		Thread.sleep(2000);

		List<WebElement> row = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr"));
		System.out.println("Row size is : " + row.size());

		List<WebElement> col = driver.findElements(By.xpath("//table[contains(@id,'orderGrid')]/tbody/tr/th"));
		System.out.println("Column size is : " + col.size());

		String expectedValue = "25 Loop Avenue";
		String name = "Kevin KURT";

		for (int i = 1; i <= row.size(); i++) {
			String rowText = driver
					.findElement(By.xpath("//*[@id=\"ctl00_MainContent_orderGrid\"]/tbody/tr[" + i + "]")).getText();

			if (rowText.contains(name)) {
				System.out.println("New Order details : " + rowText);
				
				String uptadetAdress = driver
						.findElement(By.xpath("//*[@id=\"ctl00_MainContent_orderGrid\"]/tbody/tr[" + i + "]/td[6]"))
						.getText();
                System.out.println("Updated adress : " + uptadetAdress);
				if (uptadetAdress.equals(expectedValue)) {
					System.out.println("Verified : " + uptadetAdress);
				} else {
					System.out.println("Not verified");
				}
				
			}
		}
	}
	
	
	
	@AfterClass
	public void tearDown() {
	    driver.close();
	}
	
}

