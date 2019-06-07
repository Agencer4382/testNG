package com.Class04;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Method.CommonMethods;

public class ToolsQaExample extends CommonMethods{
	
	@BeforeMethod(alwaysRun=true)
	public void setUp() {
		setUpDriver("chrome", "https://www.toolsqa.com/automation-practice-form/");
	}
	@DataProvider()
	public Object[][] setUpData(){
		Object [][] data=new Object[4][3];
		
		data[0][0]="Tim";
		data[0][1]="Jones";
		data[0][2]="10-20-2010";
		
		data[1][0]="Billy";
		data[1][1]="Jones";
		data[1][2]="05-05-1995";
		
		data[2][0]="Will";
		data[2][1]="Smith";
		data[2][2]="03-03-2003";
		
		data[3][0]="Will";
		data[3][1]="Smith";
		data[3][2]="04-04-2004";
		
		
		return data;
	}
	@Test(dataProvider="setUpData")
	public void getData1(String first, String last, String date) {
		 driver.findElement(By.cssSelector("input[name='firstname']")).sendKeys(first);
	     driver.findElement(By.cssSelector("input[name='lastname']")).sendKeys(last);
	     driver.findElement(By.cssSelector("input[id='datepicker']")).sendKeys(date);
		
	}
	@AfterMethod
	public void tearDown() {
	    driver.close();
	}
}
