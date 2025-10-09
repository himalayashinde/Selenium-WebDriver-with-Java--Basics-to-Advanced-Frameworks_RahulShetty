package RahulShettyAcademy.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

//	String user = "himalayashinde@gmail.com";
//	String password = "Himalaya@1234";

//	By userEmail = By.id("userEmail");
//	By userPassword = By.id("userPassword");
//	By loginbtn = By.id("login");

	WebDriver driver;

	public LandingPage(WebDriver driver) {
		// initialization
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

	// Perform login using the page object's locators and stored credentials
	/*
	 * public void login() { driver.findElement(userEmail).sendKeys(user);
	 * driver.findElement(userPassword).sendKeys(password);
	 * driver.findElement(loginbtn).click(); }
	 */

	public void loginApplication(String user,String password) {
		
		userEmail.sendKeys(user);
		
		userPassword.sendKeys(password);
		
		submitBtn.click();
	}


	public void goTo(String url) {
		driver.get(url);
	}
}
