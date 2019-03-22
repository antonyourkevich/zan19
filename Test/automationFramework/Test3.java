package automationFramework;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

class Test3 {
	// 1 task

	@Test
	void test() throws InterruptedException {

		String exePath = "C:\\first\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.booking.com");

		WebElement search = driver.findElement(By.xpath(".//input[@type=\"search\"]"));
		search.sendKeys("Paris");
		search.submit();

		Thread.sleep(1000);

		WebElement date = driver.findElement(By.xpath("(.//div[@class=\"sb-date-field__display\"])[1]"));
		date.click();

		WebElement date1 = driver.findElement(By.xpath("  (.//div[@class =\"sb-date-field__display\"])[1] "));
		date1.click();
		WebElement date2 = driver.findElement(By.xpath(
				".//td[@class =\\\"c2-day c2-day-s-in-range c2-day-s-first-in-range c2-day-s-hilighted\\\"]   "));
		date2.click();

		WebElement guests = driver.findElement(By.xpath("//*[@id=\"group_adults\"]"));
		guests.click();
		WebElement twoguests = driver.findElement(By.xpath("//*[@id=\"group_adults\"]/option[2]"));
		twoguests.click();

		
		
		
		Thread.sleep(5000);

		WebElement lowPrice = driver.findElement(By.xpath(".//a[@data-id=\"pri-1\"]"));
		lowPrice.click();

		WebElement searchButton = driver.findElement(By.xpath(".//button[@class=\"sb-searchbox__button  \"]"));
		searchButton.submit();
		Thread.sleep(5000);

		WebElement linkToHotel = driver.findElement(By.xpath(" (.//div[@class= \"sr_item_content sr_item_content_slider_wrapper \"])[1] "));
		assertTrue(linkToHotel.isDisplayed());
		Thread.sleep(4000);

		WebElement withnineRate = driver.findElement(By.xpath("  (.//div[@class=\"bui-review-score__badge\" ])[1] "));
		withnineRate.click();
		Thread.sleep(5000);

		WebElement price = driver.findElement(
				By.xpath("//*[@id=\"hotellist_inner\"]"));
		Thread.sleep(2000);

		String price1 = price.getText();
		String cleanprice = price1.substring(3);
		int priceInt = Integer.parseInt(cleanprice);
		int max = 100 * 7;
		assertTrue(max >= priceInt);

	}
		

	
}
