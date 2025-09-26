package GreenKart;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GreenKartValidation {

	public static void main(String[] args) throws Exception {
		
		utilities util = new utilities();
		
		String url = "https://rahulshettyacademy.com/seleniumPractise/#/";
		String driver_name = "webdriver.chrome.driver";
		String driver_path = "\\resources\\chromedriver.exe";

		System.setProperty(driver_name, System.getProperty("user.dir") + driver_path);

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get(url);

		System.out.println(driver.getTitle());

		String[] itemsNeeded = { "Cucumber", "Brocolli", "Beetroot", "Carrot" };

		util.addItems(driver, itemsNeeded);

		//a[@class='cart-icon']/img[@alt='Cart']
		
		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		
		System.out.println(driver.getCurrentUrl());
		
		driver.findElement(By.xpath("//input[@class='promoCode']")).sendKeys("rahulshettyacademy");
		
		driver.findElement(By.xpath("//button[@class='promoBtn']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement promoCodeInfo= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='promoInfo']")));
		
		System.out.println(promoCodeInfo.getText());
		
		
		
		
		
		Thread.sleep(5000);
		driver.quit();
	}

	

}
