package Method;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CommonMethods {
	public static WebDriver driver;
	public static void setUpDriver(String browser, String url) {
		if(browser.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver", "src\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("firefox")) {
		System.setProperty("webdriver.gecko.driver", "src\\drivers\\geckodriver.exe");
		driver= new FirefoxDriver();
		}else {
			System.out.println("Wrong browser");
		}
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(url);
		
		
		
	}

	public static void selectValueFromDD(WebElement element, String text) {
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		boolean flag=false;
		for (WebElement option : options) {
			String optionText = option.getText();
			if (optionText.equals(text)) {
				select.selectByVisibleText(text);
				System.out.println("Option with text "+text+" is avalible.");
				flag=true;
				break;
			}
		}
		if(!flag) {
			System.out.println("Option with text "+text+" is not avalible.");
		}
	}

	public static void selectValueFromDD(WebElement element, int index) {
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		if (options.size() > index) {
			select.selectByIndex(index);
		}else {
			System.out.println("Invalid index has been passed");
		}
	}

//	public static void sendText(WebElement element, String value) {
//		element.clear();
//		element.sendKeys(value);
//	}
	public static void acceptAlert() {
		try {
			Alert alt=driver.switchTo().alert();
			alt.accept();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Alert was not present");
		}
	}
	public static void dsimissAlert() {
		try {
			Alert alt=driver.switchTo().alert();
			alt.dismiss();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Alert was not present");
		}
	}
	public static String getAlertText() {
		try {
			Alert alt=driver.switchTo().alert();
			return alt.getText();
		} catch (Exception e) {
		
			e.printStackTrace();
			System.out.println("Alert was not present");
			return null;
		}
	}

	public static void switchToFrame(String idOrName) {
		try {
			driver.switchTo().frame(idOrName);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Frame is not present");
		}
	}
	public static void switchToFrame(WebElement element) {
		try {
			driver.switchTo().frame(element);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Frame is not present");
		}
	}
	public static void switchToFrame(int index) {
		try {
			driver.switchTo().frame(index);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Frame is not present");
		}
	}
	public static void sendText(WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}
	public static void clickRadiAndChechk(WebElement element) {
		try {
			element.click();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	
	}
}
