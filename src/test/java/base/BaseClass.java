package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utils.ConfigReader;
import utils.LoggerUtils;


public class BaseClass {
	protected static WebDriver driver;
	
	@BeforeMethod(alwaysRun = true)
	public static void setup() {

//		String browser = ConfigReader.get("browser");
		String browser = System.getProperty("browser", "chrome");
		
		switch (browser) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		default:
			driver = new InternetExplorerDriver();
			break;
		}
		
		
		driver.manage().window().maximize();
		driver.get(ConfigReader.get("url"));
		LoggerUtils.info("Launched the application");
		int time = Integer.parseInt(ConfigReader.get("timeout"));
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
	}
	
	@AfterMethod(alwaysRun = true)
	public static void tearDown() {
		driver.quit();
		LoggerUtils.info("Closed the browser");
	}
	
	public static void elementClick(WebElement elm) {
		if(elm.isDisplayed()) {
			if(elm.isEnabled()) {
				elm.click();
			}else {
				LoggerUtils.fail("Element is not enabled");
			}
		}else {
			LoggerUtils.fail("Element is not displayed");
		}
	}

	public static void enterText(WebElement elm, String text) {
		if(elm.isDisplayed()) {
			if(elm.isEnabled()) {
				elm.sendKeys(text);
			}else {
				LoggerUtils.fail("Element is not enabled");
			}
		}else {
			LoggerUtils.fail("Element is not displayed");
		}
	}
}