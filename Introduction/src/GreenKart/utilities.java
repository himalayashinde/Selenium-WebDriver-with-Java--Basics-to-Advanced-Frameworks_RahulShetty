package GreenKart;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class utilities {

	public static void addItems(WebDriver driver, String[] itemsNeeded) {

		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

		int j = 0;

		for (int i = 0; i < products.size(); i++) {

			String[] name = products.get(i).getText().split("-");

			String formattedName = name[0].trim();

			List itemsNeededList = Arrays.asList(itemsNeeded);

			if (itemsNeededList.contains(formattedName)) {

				j++;

				// driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				// Find the button inside the same product card
				WebElement addToCartBtn = products.get(i).findElement(By.xpath("following-sibling::div/button"));
				addToCartBtn.click();

				if (j == itemsNeeded.length)
					break;

			}

		}

	}
	
}



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