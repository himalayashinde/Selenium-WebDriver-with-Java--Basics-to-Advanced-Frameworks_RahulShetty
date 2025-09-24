package selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsPractice3 {

	public static void main(String[] args) {
		
		String url = "https://rahulshettyacademy.com/dropdownsPractise/";
		
		String driver_name="webdriver.chrome.driver";
		String driver_path= "\\resources\\chromedriver.exe";
		
		System.setProperty(driver_name,System.getProperty("user.dir")+driver_path);
		WebDriver driver = new ChromeDriver();
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get(url);
		
		
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
		driver.quit();
		
		
		}
	}