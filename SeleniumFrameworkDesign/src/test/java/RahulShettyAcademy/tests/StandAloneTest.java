package RahulShettyAcademy.tests;

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

import RahulShettyAcademy.pageObjects.LandingPage;

public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException {

		// WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		String url = "https://rahulshettyacademy.com/client";
		String user = "himalayashinde@gmail.com";
		String password = "Himalaya@1234";
		String productName= "iphone 13 pro";
		
		By userEmail = By.id("userEmail");
		By userPassword = By.id("userPassword");
		By loginbtn = By.id("login");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.get(url);

		driver.findElement(userEmail).sendKeys(user);
		driver.findElement(userPassword).sendKeys(password);
		driver.findElement(loginbtn).click();

		LandingPage landingpage = new LandingPage(driver);
		
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));

		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));

		WebElement prod = products.stream()
						  .filter(product -> product.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(productName)).findFirst()
						  .orElse(null);

		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();

		
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		//ng-animating
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		
		driver.findElement(By.cssSelector("[routerlink*=cart]")).click();
		
		
		List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
		
		boolean match = cartProducts.stream().anyMatch(cartitem -> cartitem.getText().equalsIgnoreCase(productName));
		
		Assert.assertTrue(match);
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector("#toast-container"))));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".totalRow button")));
		
		driver.findElement(By.cssSelector(".totalRow button")).click();
		
		
		driver.findElement(By.cssSelector("input[placeholder='Select Country']")).sendKeys("ind");
		
		
		
	
		List<WebElement> countries = driver.findElements(By.cssSelector(".ta-results button span"));
		
		for(WebElement country : countries) {
			
			String countryName = country.getText().trim();
			
			System.out.println("Found country: " + countryName);
			
			if(countryName.equalsIgnoreCase	("India")) {
				country.click();
				 break;
			}
		}		

		Actions action = new Actions(driver);
		
		action.moveToElement(driver.findElement(By.cssSelector(".action__submit"))).build().perform();
		
		driver.findElement(By.cssSelector(".action__submit")).click();
		
		String confimOrderMsg = driver.findElement(By.cssSelector(".hero-primary")).getText();
		
		//	Assert.assertEquals( ," Thankyou for the order. ");
		Assert.assertTrue(confimOrderMsg.equalsIgnoreCase("Thankyou for the order."));
		
		Thread.sleep(3000);
		driver.quit();
	}

}
