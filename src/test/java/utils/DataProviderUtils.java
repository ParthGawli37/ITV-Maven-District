package utils;

import org.testng.annotations.DataProvider;

public class DataProviderUtils {

	@DataProvider(name="loginData")
	public Object[][] getData(){
		return new Object[][] {
			{"admin123","admin"},
			{"Admin","admin"},
			{"admin123","admin123"},
			{"Admin","admin123"}
		};
	}
}