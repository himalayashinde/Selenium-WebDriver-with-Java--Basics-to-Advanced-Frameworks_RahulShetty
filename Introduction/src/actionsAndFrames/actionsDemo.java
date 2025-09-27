package actionsAndFrames;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class actionsDemo {

	public static void main(String[] args) throws Exception {
	
		String url= "https://www.amazon.in/";
		
		String driver_name= "webdrive.chrome.driver";
		String driver_path = "\\resources\\chromedriver.exe";
		
		
		By Account_and_List = By.xpath("//a[@data-csa-c-slot-id='nav-link-accountList']");
		System.setProperty(driver_name,System.getProperty("user.dir") +driver_path);
		
		WebDriver driver = new ChromeDriver();
		
		driver.get(url);
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		System.out.println(driver.getTitle());
		
		Actions action = new Actions(driver);
		
		WebElement act_list= driver.findElement(Account_and_List);
		
		action.moveToElement(act_list).build().perform();
		
		
		WebElement searchBar = driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']"));
		
		action.moveToElement(searchBar)
		.click()
		.keyDown(Keys.SHIFT)
		.sendKeys("lavamobile")
		.doubleClick()
		.build()
		.perform();
		
		Thread.sleep(3000);
		
		driver.quit();
		
		
		
	}

}
