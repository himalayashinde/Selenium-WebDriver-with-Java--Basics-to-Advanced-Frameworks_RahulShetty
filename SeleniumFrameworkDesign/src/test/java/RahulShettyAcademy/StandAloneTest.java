package RahulShettyAcademy;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException {

		// WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		String url = "https://rahulshettyacademy.com/client";
		String user = "himalayashinde@gmail.com";
		String password = "Himalaya@1234";

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
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));

		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));

		WebElement prod = products.stream()
						  .filter(product -> product.findElement(By.cssSelector("b")).getText().equalsIgnoreCase("iphone 13 pro")).findFirst()
						  .orElse(null);

		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();

		
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		//ng-animating
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		
		driver.findElement(By.cssSelector("[routerlink*=cart]")).click();
		
		
		
		Thread.sleep(3000);
		//driver.quit();
	}

}
