package RahulShettyAcademy.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import RahulShettyAcademy.AbstractComponents.AbstractComponent;

public class OrderPage extends AbstractComponent{

	WebDriver driver;

	public OrderPage(WebDriver driver) {
		// initialization
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	
	//List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));

	@FindBy(css= "tr td:nth-child(3)")
	List<WebElement> productNames;
	
	//driver.findElement(By.cssSelector(".totalRow button")).click();
	
	@FindBy(css=".totalRow button")
	WebElement checkoutElement;
	
	@FindBy(css= "#toast-container")
	WebElement PopUpMsg;
	
	By checkoutBtn= By.cssSelector(".totalRow button");
	
	public Boolean VerifyOrderDisplay(String productName) {
		
		boolean match = productNames.stream().anyMatch(cartitem -> cartitem.getText().equalsIgnoreCase(productName));
		return match;		
	}  
	
	
}
