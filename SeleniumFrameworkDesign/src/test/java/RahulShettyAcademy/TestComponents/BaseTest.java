package RahulShettyAcademy.TestComponents;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import RahulShettyAcademy.AbstractComponents.AbstractComponent;
import RahulShettyAcademy.pageObjects.LandingPage;

public class BaseTest {

	public WebDriver driver;
	String url = "https://rahulshettyacademy.com/client";
	public LandingPage landingpage;

	public WebDriver initilizeDriver() throws Exception {

		Properties prop = new Properties();
		String filePath = System.getProperty("user.dir")
				+ "\\src\\main\\java\\RahulShettyAcademy\\resources\\GlobalData.properties";
		FileInputStream fis = new FileInputStream(filePath);

		prop.load(fis);

		String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		return driver;
	}

	@BeforeMethod(alwaysRun=true)
	public LandingPage launchApplication() throws Exception {

		driver = initilizeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// LandingPage

		landingpage = new LandingPage(driver);

		landingpage.goTo(url);

		return landingpage;
	}

	@AfterMethod(alwaysRun=true)
	public void tearDown() throws Exception {
		
			Thread.sleep(3000);
		
			driver.quit();
	}
}
