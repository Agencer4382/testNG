package src.test.java.com.syntax.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.syntax.utils.BaseClass;

public class LoginPageWithoutPageFoctory extends BaseClass {
	
//	public WebElement username=driver.findElement(By.id("txtUsername"));
//	public WebElement password=driver.findElement(By.id("txtPassword"));
//	public WebElement btnLogin=driver.findElement(By.id("btnLogin"));
	
	
	@FindBy(id="txtUsername")
	public WebElement username;
	
	@FindBy(id="txtPassword")
	public WebElement password;
	
	@FindBy(id="btnLogin")
	public WebElement loginBtn;

	

	public void loginPage() {
	PageFactory.initElements(driver, this);
		
	}

}
