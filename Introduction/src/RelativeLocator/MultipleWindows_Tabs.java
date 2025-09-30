package RelativeLocator;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleWindows_Tabs {

	public static void main(String[] args) throws InterruptedException, Exception {
		// TODO Auto-generated method stub

		String url = "https://rahulshettyacademy.com/angularpractice/";
		
		String url2 = "https://rahulshettyacademy.com/";
		
		

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		

		driver.get(url);
		
		driver.switchTo().newWindow(WindowType.TAB);
		
		Set<String> windows = driver.getWindowHandles();
		 Iterator<String> it = windows.iterator();
		
		 String parentWindow = it.next();
		 String childWindow  = it.next();
		 
		 driver.switchTo().window(childWindow);
		 
//		 Thread.sleep(3000);
		 
		 driver.get(url2);
		 
		String courseName = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p/']")).get(1).getText();
		 
		System.out.println(courseName);
		
//		Thread.sleep(3000);

		driver.switchTo().window(parentWindow);
		
		WebElement name= driver.findElement(By.xpath("//input[@name='name']"));
		name.sendKeys(courseName);
		File srcfile = name.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcfile, new File(System.getProperty("user.dir")+"\\Screenshots\\logo.png"));
		
		
		System.out.println(name.getRect().getDimension().getHeight());
		System.out.println(name.getRect().getDimension().getWidth());
		
		
		Thread.sleep(3000);
		driver.quit();
		
	}

}
