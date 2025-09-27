package windowHandlesConcept;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WindowHandleDemo {

	public static void main(String[] args) throws InterruptedException {

		String url = "https://rahulshettyacademy.com/loginpagePractise/";
		String driver_name = "webdriver.chrome.driver";
		String driver_path = "\\resources\\chromedriver.exe";
		
		By IterviewLink = By.xpath("//div[@class='float-right']/a[1]");
		By paragraph = By.xpath("//p[@class='im-para red']");

		System.setProperty(driver_name, System.getProperty("user.dir") + driver_path);

		WebDriver driver = new ChromeDriver();
		Actions action = new Actions(driver);
		
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get(url);

		driver.getTitle();

		driver.findElement(IterviewLink).click();

		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentId = it.next();
		String childID = it.next();

		driver.switchTo().window(childID);
		
		action.scrollToElement(driver.findElement(paragraph)).build().perform();
		
		System.out.println(driver.findElement(paragraph).getText());
		//driver.findElement(paragraph).getText();
		
		System.out.println(driver.findElement(paragraph).getText().split("at")[1].trim().split(" ")[0]);
		String emailId = driver.findElement(paragraph).getText().split("at")[1].trim().split(" ")[0];
		
		Thread.sleep(4000);
		
		driver.switchTo().window(parentId);
		
		driver.findElement(By.id("username")).sendKeys(emailId);
		
		Thread.sleep(4000);
		
		driver.quit();

	}

}
