package automationFramework;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Test1 {
//2 task
	@Test
	public void test() throws InterruptedException {
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

		WebElement date1 = driver.findElement(By.xpath("  (.//div[@class =\'c2-day c2-day-s-disabled c2-day-s-today c2-day-s-in-range c2-day-s-first-in-range'])[1] "));
		date1.click();
		WebElement date2 = driver.findElement(By.xpath(
				".//td[@class =\\\"c2-day c2-day-s-in-range c2-day-s-first-in-range c2-day-s-hilighted\\\"]   "));
		date2.click();

		WebElement adults = driver.findElement(By.xpath("//*[@id=\"group_adults\"]"));
		adults.click();

		WebElement fouradults = driver.findElement(By.xpath("  //*[@id=\"group_adults\"]/option[4] "));
		fouradults.click();

		Thread.sleep(1000);

		WebElement room = driver.findElement(By.xpath(" .//select[@id=\"no_rooms\"] "));
		room.click();
		WebElement tworooms = driver.findElement(By.xpath("  //*[@id=\"no_rooms\"]/option[2] "));
		tworooms.click();

		Thread.sleep(1000);

		WebElement searchButton = driver.findElement(By.xpath(".//button[@class=\"sb-searchbox__button  \"]"));
		searchButton.submit();
		Thread.sleep(2000);

		WebElement highPrice = driver.findElement(By.xpath("(.//a[@class =\"bui-slider__handle\"])[1]"));
		highPrice.click();
		Thread.sleep(2000);

		WebElement lowPrice = driver.findElement(By.xpath(".//a[@data-id=\\\"pri-1\\\"]"));
		lowPrice.click();
		Thread.sleep(3000);

		WebElement price = driver
				.findElement(By.xpath("//*[@id=\"hotellist_inner\"]/div[1]/div[2]/div[2]/div/div[2]/div"));
		Thread.sleep(2000);

		String price2 = price.getText();
		String priceClean = (price2.substring(25, 26)).trim();
		String priceClean2 = price2.substring(27, 30);
		String priceClean3 = priceClean + priceClean2;

		int priceInt = Integer.parseInt(priceClean);
		int min = 477 * 7;
		assertTrue(min <= priceInt);

		
		
		
		
		
		
		
		
		
		//3 task
		
		
		WebElement booking = driver
				.findElement(By.xpath("(.//a[@class=\"b-button b-button_primary sr_cta_button\"])[1]"));
		booking.click();
		Thread.sleep(2000);

		Set<String> nextWindow = driver.getWindowHandles();
		for (String windowHandle : nextWindow) {
			driver.switchTo().window(windowHandle);
		}

		WebElement bookingButton = driver.findElement(By.xpath("(.//button[@id=\"hp_book_now_button\"])[1]"));
		bookingButton.click();
		Thread.sleep(2000);

		WebElement bookingBut = driver
				.findElement(By.xpath("(.//select[@data-component=\"hotel/new-rooms-table/select-rooms\"])[1]"));
		Select select = new Select(bookingBut);
		select.selectByIndex(1);
		Thread.sleep(2000);
		WebElement bookButton = driver.findElement(By.xpath("(.//button[@id=\"hcta\"])[1]"));
		bookButton.click();
		Thread.sleep(2000);

		Set<String> moreWindows = driver.getWindowHandles();
		for (String winHandle : moreWindows) {
			driver.switchTo().window(winHandle);
		}

		WebElement titleDropdown = driver.findElement(By.xpath(".//select[@id=\"booker_title\"]"));
		Select selectTitle = new Select(titleDropdown);
		selectTitle.selectByIndex(2);

		WebElement firstname = driver.findElement(By.xpath(".//input[@name=\"firstname\"]"));
		firstname.sendKeys("Anton");
		Thread.sleep(1000);

		WebElement lastname = driver.findElement(By.xpath(".//input[@name=\"lastname\"]"));
		lastname.sendKeys("Yurkevich");
		Thread.sleep(1000);

		WebElement email = driver.findElement(By.xpath(".//input[@name=\"email\"]"));
		email.sendKeys("antonyourkevich09@mail.ru");
		Thread.sleep(1000);

		WebElement emailConfirm = driver.findElement(By.xpath(".//input[@name=\"email_confirm\"]"));
		emailConfirm.sendKeys("antonyourkevich09@mail.ru");
		Thread.sleep(1000);

		WebElement book = driver.findElement(By.xpath(".//button[@name=\"book\"]"));
		book.click();
		Thread.sleep(2000);

		WebElement address = driver.findElement(By.xpath(".//input[@name=\"address1\"]"));
		address.sendKeys("Landera");
		Thread.sleep(1000);

		WebElement city = driver.findElement(By.xpath(".//input[@name=\"city\"]"));
		city.sendKeys("Minsk");
		Thread.sleep(1000);

		WebElement phone = driver.findElement(By.xpath(".//input[@name=\"phone\"]"));
		phone.sendKeys("123456789");
		Thread.sleep(1000);

		WebElement cardTypeDropdown = driver.findElement(By.xpath(".//select[@name=\"cc_type\"]"));
		Select selectCardType = new Select(cardTypeDropdown);
		selectCardType.selectByIndex(2);
		Thread.sleep(1000);

		WebElement cardNumber = driver.findElement(By.xpath(".//input[@name=\"cc_number\"]"));
		cardNumber.sendKeys(" 4242 4242 4242 4242");
		Thread.sleep(1000);

		WebElement incorrectCardNumberMessage = driver.findElement(By.xpath(
				".//div[@class=\"pay-form--field bp_form__field bp_form__field--cc_number bp_form__field--error\"]/descendant::p[@class=\"bp_form__field__msg\"]"));
		assertTrue(incorrectCardNumberMessage.isDisplayed());
		Thread.sleep(1000);
	}
}