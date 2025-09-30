package RelativeLocator;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class RelativeLoc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String url ="https://rahulshettyacademy.com/angularpractice/";
		
		WebDriver driver = new ChromeDriver();
		
		
		driver.get(url);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement nameEditBox = driver.findElement(By.xpath("//input[@name='name']"));
		
		System.out.println( driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText());	
		
	}

}
