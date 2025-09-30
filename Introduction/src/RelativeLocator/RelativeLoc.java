package RelativeLocator;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class RelativeLoc {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		String url = "https://rahulshettyacademy.com/angularpractice/";

		WebDriver driver = new ChromeDriver();

		driver.get(url);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebElement nameEditBox = driver.findElement(By.xpath("//input[@name='name']"));

		System.out.println(driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText());

		WebElement dateOfBirth = driver.findElement(By.xpath("//label[@for='dateofBirth']"));

		driver.findElement(with(By.tagName("input")).below(dateOfBirth)).click();

		System.out.println(driver.findElement(By.cssSelector(".alert")).getText());

		WebElement iceCreamLabel = driver
				.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));

		driver.findElement(with(By.tagName("input")).toLeftOf(iceCreamLabel)).click();

		WebElement rdb = driver.findElement(By.id("inlineRadio1"));

		System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(rdb)).getText());

		Thread.sleep(3000);

		driver.quit();

	}

}
