package com.syntax.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.syntax.utils.BaseClass;

public class HomePage extends BaseClass {
	
	@FindBy(xpath="//li[text()='Dashboard']")
	public WebElement dashboardText;
	
	@FindBy(xpath="//*[@id=\"menu_pim_viewPimModule\"]/a/span[2]")
	public WebElement pimBtn;
	
	@FindBy(xpath="//span[text()='Add Employee']")
	public WebElement addEmp;
	
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

}
