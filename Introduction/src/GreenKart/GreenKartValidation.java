package GreenKart;

import java.lang.reflect.Array;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GreenKartValidation {

	public static void main(String[] args) throws Exception {

		String url = "https://rahulshettyacademy.com/seleniumPractise/#/";
		String driver_name = "webdriver.chrome.driver";
		String driver_path = "\\resources\\chromedriver.exe";

		System.setProperty(driver_name, System.getProperty("user.dir") + driver_path);

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get(url);

		System.out.println(driver.getTitle());

		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		/*
		 * int i= -1;
		 * 
		 * for (WebElement product : products) {
		 * 
		 * String name = product.getText();
		 * 
		 * i++; //System.out.println("Value of i= "+i); if (name.contains("Cucumber")) {
		 * 
		 * System.out.println(product.getText()); System.out.println("Value of i= "+i);
		 * driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click(
		 * );
		 * 
		 * } }
		 */
		int j = 0;
		String[] itemsNeeded = { "Cucumber", "Brocolli", "Beetroot", "Carrot" };
		
		for (int i = 0; i < products.size(); i++) {

			String[] name = products.get(i).getText().split("-");

			String formattedName = name[0].trim();

			List itemsNeededList = Arrays.asList(itemsNeeded);


			if (itemsNeededList.contains(formattedName)) {

				j++;
				
				//driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				// Find the button inside the same product card
		        WebElement addToCartBtn = products.get(i).findElement(By.xpath("following-sibling::div/button"));
		        addToCartBtn.click();
				
				if (j == itemsNeeded.length)
					break;

			}

		}

		Thread.sleep(5000);
		driver.quit();
	}

}
