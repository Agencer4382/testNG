package src.test.java.com.syntax.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.syntax.utils.BaseClass;

public class AddEmployeesPage extends BaseClass {
	
	@FindBy(id="firstName")
    public WebElement firstName;
    
    @FindBy(id="middleName")
    public WebElement middleName;
    
    @FindBy(id="lastName")
    public WebElement lastName;
    
    @FindBy(id="employeeId")
    public WebElement employeeId;
    
    @FindBy(xpath="//div[@id='location_inputfileddiv']//input")
    public WebElement location;
    
    @FindBy(xpath="//div[@id='location_inputfileddiv']//ul")
    public WebElement locationList;
    
    @FindBy(xpath="//input[@id='chkLogin']")
    public WebElement createLoginDetails;
    
    @FindBy(id="systemUserSaveBtn")
    public WebElement saveBtn;
    
    @FindBy(xpath="//span[@id='pim.navbar.employeeName']")
    public WebElement empCheck;
    
    public AddEmployeesPage() {
        PageFactory.initElements(driver,this);
    }
}
