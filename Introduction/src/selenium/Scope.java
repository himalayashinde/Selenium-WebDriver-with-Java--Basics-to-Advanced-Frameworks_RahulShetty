package selenium;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scope {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		// give me the count of links on the page

		String url = "https://rahulshettyacademy.com/AutomationPractice/";

		String driver_name = "webdiver.chrome.driver";
		String driver_path = "\\resources\\chromedriver.exe";

		System.setProperty(driver_name, System.getProperty("user.dir") + driver_path);

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get(url);

		System.out.println("Page links Count= " + driver.findElements(By.tagName("a")).size());

		WebElement footerDriver = driver.findElement(By.id("gf-BIG"));

		System.out.println("Footer Links Count= " + footerDriver.findElements(By.tagName("a")).size());

		WebElement ColumnDriver = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));

		System.out.println("Column Links Count= " + ColumnDriver.findElements(By.tagName("a")).size());

		int SizeOfColumnDriver = ColumnDriver.findElements(By.tagName("a")).size();

		// click all the links in the column driver

		for (int i = 1; i < SizeOfColumnDriver; i++) {

			String newTabclick = Keys.chord(Keys.CONTROL, Keys.ENTER);
			ColumnDriver.findElements(By.tagName("a")).get(i).sendKeys(newTabclick);

			Thread.sleep(5000);
		}
		
			Set<String> windows = driver.getWindowHandles();
			Iterator<String> it = windows.iterator();

			while (it.hasNext()) {
				driver.switchTo().window(it.next());
				System.out.println(driver.getTitle());
			}

		

		driver.quit();

	}

}
