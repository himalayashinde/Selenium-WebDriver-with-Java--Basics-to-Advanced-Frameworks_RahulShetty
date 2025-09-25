package selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LocatorsPractice3 {

	public static void main(String[] args) {
		
		String url = "https://rahulshettyacademy.com/dropdownsPractise/";
		
		By staticDropDown = By.id("ctl00_mainContent_DropDownListCurrency");
		
		
		String driver_name="webdriver.chrome.driver";
		String driver_path= "\\resources\\chromedriver.exe";
		
		System.setProperty(driver_name,System.getProperty("user.dir")+driver_path);
		WebDriver driver = new ChromeDriver();
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get(url);
		
		WebElement Currency =driver.findElement(staticDropDown);
		
		Select dropdown = new Select(Currency); 
		dropdown.selectByIndex(3);
		System.out.println(dropdown.getFirstSelectedOption().getText());
		dropdown.selectByVisibleText("AED");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		
		 
		
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
		driver.quit();
		
		
		}
	}