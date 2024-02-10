package air.malta.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	protected WebDriver base_page_driver;

	public BasePage(WebDriver base_page_driver) {
		this.base_page_driver = base_page_driver;
	}
	
	public void wait_elements(WebDriver driver, int time, By element_name) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOfElementLocated(element_name));
	}
	
	 public void wait_elements_click(WebDriver driver, int time, By element_name) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
			wait.until(ExpectedConditions.elementToBeSelected(element_name));
		}
}
