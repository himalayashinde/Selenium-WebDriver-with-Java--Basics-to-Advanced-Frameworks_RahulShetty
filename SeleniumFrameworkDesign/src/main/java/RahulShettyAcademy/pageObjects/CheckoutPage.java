package RahulShettyAcademy.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import RahulShettyAcademy.AbstractComponents.AbstractComponent;

public class CheckoutPage extends AbstractComponent {

	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// driver.findElement(By.cssSelector("input[placeholder='Select
	// Country']")).sendKeys("ind");
	@FindBy(css = "input[placeholder='Select Country']")
	WebElement country;

	// driver.findElement(By.cssSelector(".action__submit")).click();
	@FindBy(css = ".action__submit")
	WebElement submit;

//	List<WebElement> countries = driver.findElements(By.cssSelector(".ta-results button span"));
	@FindBy(css = ".ta-results button span")
	List<WebElement> ListOfCountries;

	public void selectCountry(String preferedCountryName) {

		country.sendKeys(preferedCountryName);
		
		for (WebElement Selectedcountry : ListOfCountries) {

			String countryName = Selectedcountry.getText().trim();

			System.out.println("Found country: " + countryName);

			if (countryName.equalsIgnoreCase(preferedCountryName)) {
				Selectedcountry.click();
				break;
			}
		}
	}
	
	
	public ConfirmationPage submitOrder() {
		
		Actions action = new Actions(driver);
		
		action.moveToElement(submit).build().perform();		
		
		submit.click();
		
		return new ConfirmationPage(driver);
	}

}
