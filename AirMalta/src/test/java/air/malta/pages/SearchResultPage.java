package air.malta.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultPage extends BasePage{

	public SearchResultPage(WebDriver base_page_driver) {
		super(base_page_driver);
	}
	
	// elements
	private By flexible_dates_link = By.xpath("/html/body/div[2]/div/div[2]/div[4]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/a");
	
	// actions
	public void click_on_flexible_dates_link() {
		
		wait_elements(base_page_driver, 60, flexible_dates_link);
		base_page_driver.findElement(flexible_dates_link).click();
	}
}
