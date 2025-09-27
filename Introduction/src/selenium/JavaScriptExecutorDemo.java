package selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class JavaScriptExecutorDemo {

	public static void main(String[] args) throws InterruptedException {

		String url = "https://rahulshettyacademy.com/AutomationPractice/";
		String driver_name = "webdriver.chrome.driver";
		String driver_path = "\\resources\\chromedriver.exe";

		System.setProperty(driver_name, System.getProperty("user.dir") + driver_path);

		WebDriver driver = new ChromeDriver();

//		JavascriptExecutor driver;
		JavascriptExecutor js = (JavascriptExecutor) driver;

		driver.get(url);

		js.executeScript("window.scrollBy(0,500)");

		Thread.sleep(Duration.ofSeconds(3));

		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");

		List<WebElement> Amounts = driver.findElements(By.xpath("(//table[@id='product'])[2]/tbody/tr/td[4]"));
		int sum = 0;

		for (WebElement element : Amounts) {
			System.out.println("Amount = " + element.getText());
			sum = sum + Integer.parseInt(element.getText());

		}

		System.out.println("Total Amount Collected:= " + sum);

		// driver.findElement(By.cssSelector(".totalAmount")).getText();

		String totalAmt = driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim();

		int tamt = Integer.parseInt(totalAmt);

		if (sum == tamt)
			System.out.println("The Test is passed for total Amount");

		
		Assert.assertEquals(sum, tamt);


		driver.quit();
	}

}
