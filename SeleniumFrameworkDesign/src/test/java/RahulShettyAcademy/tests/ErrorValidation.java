package RahulShettyAcademy.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import RahulShettyAcademy.TestComponents.BaseTest;
import RahulShettyAcademy.pageObjects.CartPage;
import RahulShettyAcademy.pageObjects.CheckoutPage;
import RahulShettyAcademy.pageObjects.ConfirmationPage;
import RahulShettyAcademy.pageObjects.LandingPage;
import RahulShettyAcademy.pageObjects.ProductCatalogue;

public class ErrorValidation extends BaseTest {

	String user = "himalayashinde@gmail2.com";
	String user1= "himalayashinde@gmail.com";
	String password = "Himalaya@1234";
	String productName = "iphone 13 pro";

	@Test
	public void LoginErrorValidation() throws Exception {

		// ProductCatalogue

		ProductCatalogue productCatalogue = landingpage.loginApplication(user, password);

		String ErrorMsg = landingpage.getErrorMessage();
		Assert.assertEquals("Incorrect email or password.", ErrorMsg);

	}

	
	@Test
	public void ProductErrorValidation() throws Exception {

		// ProductCatalogue

		ProductCatalogue productCatalogue = landingpage.loginApplication(user1, password);

		List<WebElement> products = productCatalogue.getProductsList();

		productCatalogue.getProductByname(productName);
		productCatalogue.addProductToCart(productName);

		// CartPage

		CartPage cartpage = productCatalogue.goToCartPage();

		Boolean match = cartpage.VerifyProductDisplay("iphone 13 pro Max");

		Assert.assertFalse(match);
		
	}
}
