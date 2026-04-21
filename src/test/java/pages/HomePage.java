package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;
import utils.LoggerUtils;

public class HomePage extends BaseClass{
	WebDriver driver;
	
	
	//page specific locators
//	By imgSearch = By.xpath("//div[@class='dds-w-7 dds-h-7 dds-flex dds-items-center dds-cursor-pointer']//*[name()='svg']");
//	By imgLocation = By.xpath("//div[@class='dds-w-8 dds-h-8 dds-flex dds-items-center dds-justify-center']//*[name()='svg']");

	@FindBy(xpath = "//div[@class='dds-w-7 dds-h-7 dds-flex dds-items-center dds-cursor-pointer']//*[name()='svg']")
	WebElement imgSearch;
	
	@FindBy(xpath = "//div[@class='dds-w-8 dds-h-8 dds-flex dds-items-center dds-justify-center']//*[name()='svg']")
	WebElement imgLocation;
	
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//page specific methods
	public void clickSearch() {
//		driver.findElement(imgSearch).click();
//		imgSearch.click();
		elementClick(imgSearch);
		LoggerUtils.info("Clicked on Search icon");
	}
	
	public void clickLocation() {
//		driver.findElement(imgLocation).click();
//		imgLocation.click();
		elementClick(imgLocation);
		LoggerUtils.info("Clicked on Location icon");
	}
}