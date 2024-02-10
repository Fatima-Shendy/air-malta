package air.malta.testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import air.malta.pages.CalenderPage;
import air.malta.pages.SearchPage;
import air.malta.pages.SearchResultPage;

public class SearchPageTest extends BaseTest{
	
	SearchPage searchPage;
	SearchResultPage searchResultPage;
	CalenderPage calenderPage;
	

	@Test
	public void testSearchWithEmptyForm() {
		searchPage = new SearchPage(base_test_driver);
		searchPage.click_on_find_best_fare_link();
		searchPage.click_on_search_btn();
		
		String departingFromErrMsg = searchPage.getDepartingFromErrorMessage();
		String flyingToErrMsg = searchPage.getFlyingToErrorMessage();
		
		AssertJUnit.assertEquals(departingFromErrMsg, "Please provide us with a departure location");
		AssertJUnit.assertEquals(flyingToErrMsg, "Please provide us with an arrival location");
	}
	
	@Test
	public void testSearchWithoutFlyingToLocation() {
		searchPage = new SearchPage(base_test_driver);
		searchPage.click_on_find_best_fare_link();
		searchPage.insert_trip_type("One-way");
		searchPage.insert_departing_from("Vienna, Vienna International Airport (VIE), Austria");
		searchPage.click_on_search_btn();
		
		String flyingToErrMsg = searchPage.getFlyingToErrorMessage();
		AssertJUnit.assertEquals(flyingToErrMsg, "Please provide us with an arrival location");
	}
	
	@Test
	public void testSearchWithoutDepartingLocation() {
		searchPage = new SearchPage(base_test_driver);
		searchPage.click_on_find_best_fare_link();
		searchPage.insert_trip_type("One-way");
		searchPage.insert_flying_to("Malta, Luqa Airport (MLA), Malta");
		searchPage.click_on_search_btn();
		
		String departingFromErrMsg = searchPage.getDepartingFromErrorMessage();
		AssertJUnit.assertEquals(departingFromErrMsg, "Please provide us with a departure location");
	}
	
	@Test
	public void testSearchWithValidData() {
		searchPage = new SearchPage(base_test_driver);
		
		searchPage.click_on_find_best_fare_link();
		searchPage.insert_trip_type("One-way");
		searchPage.insert_departing_from("Vienna, Vienna International Airport (VIE), Austria");
		searchPage.insert_flying_to("Malta, Luqa Airport (MLA), Malta");
		searchPage.click_on_search_btn();
		
		searchResultPage = new SearchResultPage(base_test_driver);
		searchResultPage.click_on_flexible_dates_link();
		
		calenderPage = new CalenderPage(base_test_driver);
		String firstAvailableFlightPrice = calenderPage.getFirstAvailableFlightPrice();
		AssertJUnit.assertNotSame(firstAvailableFlightPrice, "");
	}
}
