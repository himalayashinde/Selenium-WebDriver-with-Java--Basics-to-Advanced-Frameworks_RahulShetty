package selenium;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class fluentWaitTest {

	public static void main(String[] args) {
		String url = "https://the-internet.herokuapp.com/dynamic_loading/1";
		
		String driver_name= "webdriver.chrome.driver";
		String driver_path= "\\resources\\chromedriver.exe";

		System.setProperty(driver_name, System.getProperty("user.dir")+driver_path);
		
		WebDriver driver = new ChromeDriver();
		
		driver.get(url);
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		By startBtn = By.xpath("//div[@id='start']/button");
		
		driver.findElement(startBtn).click();
		
		Wait<WebDriver> wait =new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(3))
				.ignoring(Exception.class);
				
		
		WebElement hellotext = wait.until(
				
				new Function<WebDriver, WebElement>(){

					@Override
					public WebElement apply(WebDriver driver) {
					
					WebElement element = driver.findElement(By.cssSelector("div[id='finish'] h4"));
					
						if(element.isDisplayed())	
							return element;
						else
							return null;
					}
					
				});
		
		System.out.println(hellotext.getText());
		
		driver.quit();
	}

}
