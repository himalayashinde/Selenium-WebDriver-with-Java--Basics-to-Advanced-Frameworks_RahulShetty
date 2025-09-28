package miscellaneous;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SSLCheck {

	public static void main(String[] args) throws InterruptedException {
		
		String url = "https://expired.badssl.com/";
		String driver_name= "webdriver.chrome.driver";
		String driver_path="\\resources\\chromedriver.exe";
		
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		
		System.setProperty(driver_name, System.getProperty("user.dir") +driver_path);
		
		WebDriver driver = new ChromeDriver(options);
		
		driver.get(url);
		
		System.out.println(driver.getTitle());		
		
		Thread.sleep(3000);
		driver.quit();
	}

}
