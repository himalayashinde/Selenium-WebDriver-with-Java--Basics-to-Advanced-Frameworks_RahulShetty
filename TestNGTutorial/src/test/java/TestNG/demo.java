package TestNG;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class demo {
	
	
	@AfterTest
	public void executeAtLast() {
		System.out.println("executeAtLast of the method");
	}

	@Test
	public void helloworld() {
		System.out.println("Hello from TestNG");
		
	}
	
	@Parameters({"URL","APIKey"})
	@Test(groups= {"Smoke"})
	public void secondTest(String url, String key) {
		
		System.out.println("Second Test created= " + url);
		System.out.println(key);
	}
	
	@BeforeTest
	public void executeAtFirst() {
		System.out.println("executeAtFirst of all the methods");
	}
}
