package GreenKart;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class streamOnWebtables {

	public static void main(String[] args) throws Exception {
		
		
		String url = "https://rahulshettyacademy.com/seleniumPractise/#/offers";
				
		WebDriver driver = new ChromeDriver();
		
		driver.get(url);
		
		//click on the column
		
		//capture the webelements in the list 
		
		//capture text of all webelements into new list 
		
		//sort in the list of step 3 > sorted list 
		
		// //table/thead/tr/th[1]/span
		
		driver.findElement(By.xpath("//table/thead/tr/th[1]/span")).click();
		
		 List<WebElement> elementsList = driver.findElements(By.xpath(" //tr/td[1]"));
		 
		 List<String> originalList = elementsList.stream().map(s->s.getText()).collect(Collectors.toList());
		
		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
				
		Assert.assertTrue(originalList.equals(sortedList));
		
		
		List<String> price = elementsList.stream().filter(s->s.getText().contains("Beans"))
		.map(s->getVeggiesPrice(s)).collect(Collectors.toList());
		
		price.forEach(a->System.out.println(a));
		
		
		Thread.sleep(3000);
		
		driver.quit();		
				

	}

	private static String getVeggiesPrice(WebElement s) {
		// TODO Auto-generated method stub
		
		String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		 
		return priceValue;
	}

}
