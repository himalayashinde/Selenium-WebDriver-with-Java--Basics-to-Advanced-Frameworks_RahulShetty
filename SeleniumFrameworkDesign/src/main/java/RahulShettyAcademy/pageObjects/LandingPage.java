package RahulShettyAcademy.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import RahulShettyAcademy.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {

//	String user = "himalayashinde@gmail.com";
//	String password = "Himalaya@1234";

//	By userEmail = By.id("userEmail");
//	By userPassword = By.id("userPassword");
//	By loginbtn = By.id("login");

	WebDriver driver;

	public LandingPage(WebDriver driver) {
		// initialization
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//  WebElement userEmail1 =	driver.findElement(userEmail);

	@FindBy(id = "userEmail")
	WebElement userEmail;

	@FindBy(id = "userPassword")
	WebElement userPassword;

	@FindBy(id = "login")
	WebElement submitBtn;

	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;
	
	
	public ProductCatalogue loginApplication(String user,String password) {
		
		userEmail.sendKeys(user);
		
		userPassword.sendKeys(password);
		
		submitBtn.click();
		
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		
		return productCatalogue;
	}


	public void goTo(String url) {
		driver.get(url);
	}
	
	public String getErrorMessage() {
		
		waitForWebElementToAppear(errorMessage);
		return errorMessage.getText();
		
	}
}
