package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.HomePage;
import pages.SearchPage;
import utils.LoggerUtils;

public class DistrictTest extends BaseClass{
	private static HomePage home;
	private static SearchPage search;
	
//	private static MovieDetailsPage movieDetails;
//	private static BookTicketPage book;
	
	@BeforeMethod(alwaysRun = true)
	public static void initializePages() {
		home = new HomePage(driver);
		search = new SearchPage(driver);
//		movieDetails = new MovieDetailsPage();
//		book = new BookTicketPage();
	}
	
	
	@Test
	public static void bookMovie() {
		LoggerUtils.info("Test case - bookMovie execution started");
		home.clickSearch();//click on the Search image on the Home page
		search.clickMovies();//click on the Movies link on the Search page
		search.enterTextToSearch("Dhurandhar"); //enter Dhurandhar in the search box on the Search page
		Assert.assertTrue(search.getSearchResult().trim().contains("Dhurandhar123"));
		LoggerUtils.pass("Search Result is showing the correct Movie details");
//		search.selectMovie();
//		movieDetails.selectDay();
//		movieDetails.addFilter();
//		movieDetails.selectTheatre();
//		movieDetails.selectShowTime();
//		book.selectSeats();
//		book.clickBookNow();
		LoggerUtils.info("Test case - bookMovie execution completed");
	}
}