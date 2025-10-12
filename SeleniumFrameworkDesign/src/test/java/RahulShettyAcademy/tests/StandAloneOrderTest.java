package RahulShettyAcademy.tests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import RahulShettyAcademy.TestComponents.BaseTest;
import RahulShettyAcademy.pageObjects.CartPage;
import RahulShettyAcademy.pageObjects.CheckoutPage;
import RahulShettyAcademy.pageObjects.ConfirmationPage;
import RahulShettyAcademy.pageObjects.LandingPage;
import RahulShettyAcademy.pageObjects.ProductCatalogue;

public class StandAloneOrderTest extends BaseTest {

	String user = "himalayashinde@gmail.com";
	String password = "Himalaya@1234";
	String productName = "iphone 13 pro";

	@Test
	public void submitOrder() throws Exception {

		LandingPage landingpage = launchApplication();

		// ProductCatalogue

		ProductCatalogue productCatalogue = landingpage.loginApplication(user, password);

		List<WebElement> products = productCatalogue.getProductsList();

		productCatalogue.getProductByname(productName);
		productCatalogue.addProductToCart(productName);

		// CartPage

		CartPage cartpage = productCatalogue.goToCartPage();

		Boolean match = cartpage.VerifyProductDisplay(productName);

		Assert.assertTrue(match);

		// CheckoutPage

		CheckoutPage checkoutpage = cartpage.goToCheckout();

		checkoutpage.selectCountry("india");

		// ConfirmationPage

		ConfirmationPage confirmationPage = checkoutpage.submitOrder();

		String confimOrderMsg = confirmationPage.getConfirmationMessage();

		Assert.assertTrue(confimOrderMsg.equalsIgnoreCase("Thankyou for the order."));

		Thread.sleep(3000);
		
		driver.quit();
	}

}
