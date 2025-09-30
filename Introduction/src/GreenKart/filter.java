package GreenKart;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class filter {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		String url = "https://rahulshettyacademy.com/seleniumPractise/#/offers";
		
		WebDriver driver = new ChromeDriver();
		
		driver.get(url);
		
		driver.findElement(By.id("search-field")).sendKeys("Rice");
		
		List<WebElement> itemNames = driver.findElements(By.xpath("//tr/td[1]"));
		
		List<WebElement> filteredList = itemNames.stream().filter(itemName->itemName.getText().contains("Rice"))
		.collect(Collectors.toList());
		
		Assert.assertEquals(itemNames.size(), filteredList.size());

		
		Thread.sleep(3000);
		
		driver.quit();
		
		
		
	}

}
