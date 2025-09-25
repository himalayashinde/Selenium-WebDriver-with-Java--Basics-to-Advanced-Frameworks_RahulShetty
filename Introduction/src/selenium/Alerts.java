package selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {

	public static void main(String[] args) {

		String url = "https://rahulshettyacademy.com/AutomationPractice/";
		String driver_name = "webdriver.chrome.driver";
		String driver_path = "\\resources\\chromedriver.exe";
		System.setProperty(driver_name, System.getProperty("user.dir")+driver_path);

		WebDriver driver = new ChromeDriver();

		driver.get(url);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();

		driver.findElement(By.id("name")).sendKeys("Himalaya");

		driver.findElement(By.id("alertbtn")).click();

		System.out.println(driver.switchTo().alert().getText());
		
		driver.switchTo().alert().accept();
		
		
		driver.findElement(By.id("name")).sendKeys("Rutuja");

		driver.findElement(By.id("confirmbtn")).click();

		System.out.println(driver.switchTo().alert().getText());
		
		driver.switchTo().alert().dismiss();
		
		driver.quit();

	}

}
