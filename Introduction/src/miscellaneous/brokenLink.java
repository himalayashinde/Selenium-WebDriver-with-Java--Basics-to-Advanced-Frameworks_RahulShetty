package miscellaneous;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class brokenLink {

	public static void main(String[] args) throws InterruptedException, Exception, IOException {


		String url ="https://rahulshettyacademy.com/AutomationPractice/";
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get(url);
		
		
		 WebElement footer = driver.findElement(By.id("gf-BIG"));
		
		 WebElement brokenLinkColumn = footer.findElement(By.xpath("//table[@class='gf-t']/tbody/tr/td[2]"));
		 
		 List<WebElement> links = brokenLinkColumn.findElements(By.tagName("a"));
		 
		 for(WebElement link : links)
		 {
			String newTabclick =  Keys.chord(Keys.CONTROL,Keys.ENTER);
			 link.sendKeys(newTabclick);
			 
			 //Thread.sleep(5000);
		 }
		 
		 Set<String> windows = driver.getWindowHandles();
		 Iterator<String> it = windows.iterator();
		 
		 while(it.hasNext())
		 {
			 driver.switchTo().window(it.next());
			 System.out.println("**********************************");
			 System.out.println("Page Title= "+driver.getTitle());
			 System.out.println("Page url= "+driver.getCurrentUrl());
			 			 
			 String validateUrl = driver.getCurrentUrl();
			 
			 HttpURLConnection connection = (HttpURLConnection)new URL(validateUrl).openConnection();
			 
			 connection.setRequestMethod("HEAD");
			 
			 connection.connect();
			 int responseCode = connection.getResponseCode();
			 System.out.println("Page Resonse Code= "+responseCode);
			 System.out.println("**********************************");
		 }
		 
			driver.quit();
		 
	}

}
