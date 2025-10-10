package RahulShettyAcademy;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import RahulShettyAcademy.pageObjects.CartPage;
import RahulShettyAcademy.pageObjects.CheckoutPage;
import RahulShettyAcademy.pageObjects.ConfirmationPage;
import RahulShettyAcademy.pageObjects.LandingPage;
import RahulShettyAcademy.pageObjects.ProductCatalogue;

public class StandAloneOrderTest {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		String url = "https://rahulshettyacademy.com/client";
		String user = "himalayashinde@gmail.com";
		String password = "Himalaya@1234";
		String productName = "iphone 13 pro";

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		//LandingPage
		
		LandingPage landingpage = new LandingPage(driver);

		landingpage.goTo(url);

		//ProductCatalogue
		
		ProductCatalogue productCatalogue = landingpage.loginApplication(user, password);

		List<WebElement> products = productCatalogue.getProductsList();

		productCatalogue.getProductByname(productName);
		productCatalogue.addProductToCart(productName);
		
		//CartPage
		
		CartPage cartpage = productCatalogue.goToCartPage();

		Boolean match = cartpage.VerifyProductDisplay(productName);

		Assert.assertTrue(match);
		
		//CheckoutPage

		CheckoutPage checkoutpage = cartpage.goToCheckout();

		checkoutpage.selectCountry("india");
		
		//ConfirmationPage
		
		ConfirmationPage confirmationPage = checkoutpage.submitOrder();

		String confimOrderMsg = confirmationPage.getConfirmationMessage();

		Assert.assertTrue(confimOrderMsg.equalsIgnoreCase("Thankyou for the order."));
		

		Thread.sleep(3000);
		driver.quit();
	}

}
