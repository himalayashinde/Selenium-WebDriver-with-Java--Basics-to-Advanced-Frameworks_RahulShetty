package miscellaneous;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.apache.commons.io.FileUtils;


public class maximixeAndDeletingCookies {

	public static void main(String[] args) throws InterruptedException, Exception {


		String url = "https://www.google.com/";
		String driver_name= "webdriver.chrome.driver";
		String driver_path="\\resources\\chromedriver.exe";
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
	
		System.setProperty(driver_name, System.getProperty("user.dir") +driver_path);
		
		WebDriver driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		
		//driver.manage().deleteAllCookies();
		
		
		driver.get(url);
		
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String fileName = "screenshot_" + System.currentTimeMillis() + ".png";
		FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\Screenshots\\"+fileName));
//		FileUtils.copyFile(src, new File("I:\\Coding_journey\\Selenium-WebDriver-with-Java--Basics-to-Advanced-Frameworks_RahulShetty\\Introduction\\Screenshots\\screenshot1.png"));
		
//		I:\Coding_journey\Selenium-WebDriver-with-Java--Basics-to-Advanced-Frameworks_RahulShetty\Introduction\Screenshots
		System.out.println(driver.getTitle());		
		
		Thread.sleep(3000);
		driver.quit();

	}

}
