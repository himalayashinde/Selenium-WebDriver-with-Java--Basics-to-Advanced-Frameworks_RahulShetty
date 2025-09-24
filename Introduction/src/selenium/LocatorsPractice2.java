package selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsPractice2 {

	public static void main(String[] args) {
		
		String url = "https://rahulshettyacademy.com/AutomationPractice/";
		By login = By.xpath("//div/button[text()='Practice']/following-sibling::button[1]");
		By meetUPText= By.xpath("//div/button[text()='Practice']/parent::div/parent::header/a[2]");
		
		String driver_name="webdriver.chrome.driver";
		String driver_path= "\\resources\\chromedriver.exe";
		
		System.setProperty(driver_name,System.getProperty("user.dir")+driver_path);
		WebDriver driver = new ChromeDriver();
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get(url);
		
		WebElement LoginText =driver.findElement(login);
		System.out.println(LoginText.getText());
		
		WebElement meetUptext= driver.findElement(meetUPText);
		
		System.out.println(meetUptext.getText());
		
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
		driver.quit();
		
		
		}
	}