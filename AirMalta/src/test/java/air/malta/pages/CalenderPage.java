package air.malta.pages;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalenderPage extends BasePage {

	public CalenderPage(WebDriver base_page_driver) {
		super(base_page_driver);
	}

	// elements
	private By flights = By.cssSelector(
			"body > div.theme-KM > div > div.sc-dAbbOL.eGhJLZ > div:nth-child(4) > div.sc-bWJUgm.jVhDBm > div.sc-kpKSZj.ffjtwY > div > div > div.sc-fatcLD.jxyhGA > div > div.sc-djTQaJ.fHScxU");

	// actions
	public String getFirstAvailableFlightPrice() {
		String day = "";
		String price = "";
		try {
			wait_elements(base_page_driver, 60, flights);

			WebElement element = base_page_driver.findElement(flights);

			List<WebElement> fligtsList = element.findElements(By.className("sc-djVXDX"));

			for (WebElement flight : fligtsList) {
				
				WebElement dayElement = flight.findElement(By.className("sc-btwKTd"));
				WebElement priceElement = null;
				try {
					priceElement = flight.findElement(By.className("sc-gVJvzJ"));
					
				} catch (Exception ex) {
					priceElement = flight.findElement(By.className("sc-dJiZtA"));
				}
				
				
				 day = dayElement.getAttribute("innerHTML");
				 price = priceElement.getAttribute("innerHTML");

				if (!price.equals("-") &&  !price.isEmpty()) {			
					System.out.println("**********************************");
					System.out.println("[Day]: "+ day);
					System.out.println("[Price]: "+ price);
					System.out.println("**********************************");
					break;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return price;
	}
}
