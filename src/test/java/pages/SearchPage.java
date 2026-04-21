package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;
import utils.LoggerUtils;

public class SearchPage extends BaseClass{
	WebDriver driver;
	
	
	//page specific By locators
//	By edtSearch = By.xpath("(//input[contains(@class,'placeholder')])[2]");
//	By lnkMovies = By.xpath("//span[text()='Movies']");
//	By lnkSearchResult = By.xpath("//h5[@class='dds-tracking-tight dds-text-lg dds-font-semibold dds-overflow-hidden dds-whitespace-normal dds-line-clamp-2 dds-text-primary dds-leading-normal dds-my-0']");
	
	//page specific WebElement locators
	@FindBy(xpath = "(//input[contains(@class,'placeholder')])[2]")
	WebElement edtSearch;
	
	@FindBy(xpath = "//span[text()='Movies']")
	WebElement lnkMovies;
	
	@FindBy(xpath = "//h5[@class='dds-tracking-tight dds-text-lg dds-font-semibold dds-overflow-hidden dds-whitespace-normal dds-line-clamp-2 dds-text-primary dds-leading-normal dds-my-0']")
	WebElement lnkSearchResult;
	
	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//page specific methods
	public void clickMovies() {
//		driver.findElement(lnkMovies).click();
//		lnkMovies.click();
		elementClick(lnkMovies);
		LoggerUtils.info("Clicked on Movies link");
	}
	
	public void enterTextToSearch(String text) {
//		driver.findElement(edtSearch).sendKeys(text);
//		edtSearch.sendKeys(text);
		enterText(edtSearch,text);
		LoggerUtils.info("Entered " + text + " in the search editbox");
	}
	
	public String getSearchResult() {
//		return driver.findElement(lnkSearchResult).getText();
		String text = lnkSearchResult.getText();
		LoggerUtils.info("Extracted Search Result text as " + text);
		return text;
	}
}