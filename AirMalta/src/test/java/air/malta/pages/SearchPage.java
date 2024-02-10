package air.malta.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class SearchPage extends BasePage{

	public SearchPage(WebDriver base_page_driver) {
		super(base_page_driver);
	}
	
	
	// elements
	private By find_best_fare_link = By.xpath("/html/body/div[2]/main/div[2]/div[1]/div[1]/div[4]/a");
	private By trip_type = By.xpath("//*[@id=\"headlessui-listbox-button-1\"]");
	private By departing_from = By.xpath("//*[@id=\"flights-booking-id-1-input\"]");
	private By flying_to = By.xpath("//*[@id=\"flights-booking-id-2-input\"]");
	private By departure_date = By.xpath("//*[@id=\"popover-panel-9\"]/div/div[1]/div[1]/div/div/div/div/div/div/div/input");
	private By search_btn = By.xpath("//*[@id=\"main\"]/div[1]/div/div/div[2]/div/div/div/div/div/div/div/div[2]/div[2]/div[3]/button");
	
	private By departing_from_err_msg = By.xpath("//*[@id=\"flights-booking-id-1-error\"]");
	private By flying_to_err_msg = By.xpath("//*[@id=\"flights-booking-id-2-error\"]");
	                              

		
	
	// actions
	public void click_on_find_best_fare_link() {
		wait_elements(base_page_driver, 30, find_best_fare_link);
	    wait_elements_click(base_page_driver, 30, find_best_fare_link);
		base_page_driver.findElement(find_best_fare_link).click();
	}


	public void insert_trip_type(String trip_type_value) {
		wait_elements(base_page_driver, 30, trip_type);
		base_page_driver.findElement(trip_type).sendKeys(trip_type_value);
	}
	
	public void insert_departing_from(String departing_from_value) {
		wait_elements(base_page_driver, 30, departing_from);
		base_page_driver.findElement(departing_from).clear();	
		base_page_driver.findElement(departing_from).sendKeys(departing_from_value);
		base_page_driver.findElement(departing_from).sendKeys(Keys.ENTER);
	}
	
	public void insert_flying_to(String flying_to_value) {
		wait_elements(base_page_driver, 30, flying_to);
		base_page_driver.findElement(flying_to).clear();
		base_page_driver.findElement(flying_to).sendKeys(flying_to_value);
		base_page_driver.findElement(flying_to).sendKeys(Keys.ARROW_DOWN);
		base_page_driver.findElement(flying_to).sendKeys(Keys.ENTER);
	}
	
	public void insert_departure_date(String departure_date_value) {
		wait_elements(base_page_driver, 30, departure_date);
		base_page_driver.findElement(departure_date).click();
		base_page_driver.findElement(departure_date).sendKeys(departure_date_value);
	}
	
	public void click_on_search_btn() {	
		base_page_driver.findElement(search_btn).click();
	}
	
	public String getDepartingFromErrorMessage() {
		String msg = base_page_driver.findElement(departing_from_err_msg).getText();
		return msg;
	}
	
    public String getFlyingToErrorMessage() {
    	String msg = base_page_driver.findElement(flying_to_err_msg).getText();
		return msg;	
	}
}
