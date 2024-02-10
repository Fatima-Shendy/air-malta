package air.malta.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest {

	protected WebDriver base_test_driver;

	@BeforeMethod
	public  void open_browser() {
		base_test_driver = new ChromeDriver();
		base_test_driver.get("https://airmalta.com/ ");
		base_test_driver.manage().window().maximize();	
	}
	
//	@BeforeTest
//	public  void close_browser() {
//		base_test_driver.close();
//	}
}
