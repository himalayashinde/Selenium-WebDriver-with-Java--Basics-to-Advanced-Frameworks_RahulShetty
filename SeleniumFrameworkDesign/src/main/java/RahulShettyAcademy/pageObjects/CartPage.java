package RahulShettyAcademy.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import RahulShettyAcademy.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent{

	WebDriver driver;

	public CartPage(WebDriver driver) {
		// initialization
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	
	//List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));

	@FindBy(css= ".cartSection h3")
	List<WebElement> cartProducts;
	
	//driver.findElement(By.cssSelector(".totalRow button")).click();
	
	@FindBy(css=".totalRow button")
	WebElement checkoutElement;
	
	@FindBy(css= "#toast-container")
	WebElement PopUpMsg;
	
	By checkoutBtn= By.cssSelector(".totalRow button");
	
	public Boolean VerifyProductDisplay(String productName) {
		
		boolean match = cartProducts.stream().anyMatch(cartitem -> cartitem.getText().equalsIgnoreCase(productName));
		return match;		
	}  
	
	public CheckoutPage goToCheckout() {
		
		waitForElementToDisappear(PopUpMsg);
		
		waitForElementToAppear(checkoutBtn);
		
		checkoutElement.click();
		
		return new CheckoutPage(driver);
	}
	

	/*
	 * @FindBy(css= ".ng-animating") WebElement spinner;
	 * 
	 * By productsBy = By.cssSelector(".mb-3"); By addToCart =
	 * By.cssSelector(".card-body button:last-of-type"); By toastMessage =
	 * By.cssSelector("#toast-container");
	 */
	
	/*
	 * public List<WebElement> getProductsList() {
	 * 
	 * waitForElementToAppear(productsBy);
	 * 
	 * return products; }
	 */

	/*
	 * public WebElement getProductByname(String productName) {
	 * 
	 * WebElement prod = getProductsList().stream() .filter(product ->
	 * product.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(
	 * productName)).findFirst() .orElse(null);
	 * 
	 * return prod; }
	 */
	
	
	/*
	 * public void addProductToCart(String productName) {
	 * 
	 * WebElement prod = getProductByname(productName);
	 * 
	 * prod.findElement(addToCart).click();
	 * 
	 * waitForElementToAppear(toastMessage);
	 * 
	 * waitForElementToDisappear(spinner);
	 * 
	 * }
	 */
}
