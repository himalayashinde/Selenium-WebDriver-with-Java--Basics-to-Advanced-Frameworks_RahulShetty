package selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CheckBoxes {

	public static void main(String[] args) throws Exception {

		String url = "https://rahulshettyacademy.com/dropdownsPractise/";

		By staticDropDown = By.id("ctl00_mainContent_DropDownListCurrency");
		By seniorCitizen = By.cssSelector("input[id*='SeniorCitizenDiscount']");
		String driver_name = "webdriver.chrome.driver";
		String driver_path = "\\resources\\chromedriver.exe";

		System.setProperty(driver_name, System.getProperty("user.dir") + driver_path);
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get(url);

		System.out.println(driver.findElement(seniorCitizen).isSelected());
		driver.findElement(seniorCitizen).click();
		System.out.println(driver.findElement(seniorCitizen).isSelected());
		
		List<WebElement> checkBoxes= driver.findElements(By.xpath("//input[@type='checkbox']"));
		System.out.println("Count of CheckBoxes= "+checkBoxes.size());
		
		WebElement Currency = driver.findElement(staticDropDown);

//		Select dropdown = new Select(Currency); 
//		dropdown.selectByIndex(3);
//		System.out.println(dropdown.getFirstSelectedOption().getText());
//		dropdown.selectByVisibleText("AED");
//		System.out.println(dropdown.getFirstSelectedOption().getText());

		driver.findElement(By.id("divpaxinfo")).click();

//		driver.findElement(By.id("hrefIncAdt")).click();

//		int i=1;
//		while(i<5) {
//			driver.findElement(By.id("hrefIncAdt")).click();
//			i++;
//		}

		for (int i = 1; i < 5; i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
		}

		driver.findElement(By.id("btnclosepaxoption")).click();

		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

		Thread.sleep(2000);

		// From
		// a[@value='BLR']

		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		System.out.println("Source= " + driver.findElement(By.xpath("//a[@value='BLR']")).getText());
		driver.findElement(By.xpath("//a[@value='BLR']")).click();

		Thread.sleep(2000);

		// to
		// a[@value='MAA'] (//a[@value='MAA'])[2]

		driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
		System.out.println("Destination= " + driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).getText());
		driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();

		// AutoSuggestive DropDowns

		driver.findElement(By.id("autosuggest")).sendKeys("ind");

		Thread.sleep(2000);

		// li[@class='ui-menu-item']/a

		List<WebElement> elements = driver.findElements(By.xpath("//li[@class='ui-menu-item']/a"));

		for (WebElement element : elements) {

			System.out.println(element.getText());

			if (element.getText().equalsIgnoreCase("indonesia")) {
				System.out.println("Selected= " + element.getText());
				element.click();
				break;
				// System.out.println("Selected= " +element.getText());
			}
		}

		driver.quit();

	}
}