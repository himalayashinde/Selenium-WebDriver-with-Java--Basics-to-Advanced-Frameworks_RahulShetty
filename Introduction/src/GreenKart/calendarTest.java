package GreenKart;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class calendarTest {

	public static void main(String[] args) {
		
		String url = "https://rahulshettyacademy.com/seleniumPractise/#/offers";
		
		String driver_name="webdriver.chrome.driver";
		String driver_path="\\resources\\chromedriver.exe";
		
		String monthNumber ="6";
		String date = "15";	
		String year="2027";
		
		String[] expectedList = {monthNumber,date,year};
		
		System.setProperty(driver_name,System.getProperty("user.dir")+driver_path);
		
		WebDriver driver = new ChromeDriver();
		
		driver.get(url);
		
		driver.findElement(By.className("react-date-picker__inputGroup")).click();
		
		driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
		
		driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
		
		driver.findElement(By.xpath("//button[text()='"+year+"']")).click();
		
		driver.findElements(By.cssSelector(".react-calendar__year-view__months__month")).get(Integer.parseInt(monthNumber)-1).click();
		
		driver.findElement(By.xpath("//abbr[text()='"+date+"']")).click();
		
		
		List<WebElement> actualList = driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));
		
		int i=0;
		for( WebElement element : actualList) {
			
			System.out.println(element.getAttribute("value"));
			Assert.assertEquals(element.getAttribute("value"), expectedList[i++]);
		}
		driver.close();
	}

}
