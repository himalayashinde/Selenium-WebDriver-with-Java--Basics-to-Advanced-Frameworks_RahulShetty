package actionsAndFrames;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class draggableDemo {

	public static void main(String[] args) throws InterruptedException {

		String url = "https://jqueryui.com/droppable/";

		String driver_name = "webdriver.chrome.driver";
		String driver_path = "\\resources\\chromedriver.exe";

		System.setProperty(driver_name, System.getProperty("user.dir") + driver_path);

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get(url);
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		

		driver.findElement(By.id("draggable")).click();
		
		Actions action = new Actions(driver);
		
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		
		action.dragAndDrop(source, target).build().perform();
		
		
		driver.switchTo().defaultContent();
		
		
		Thread.sleep(5000);
		driver.quit();
	}

}
