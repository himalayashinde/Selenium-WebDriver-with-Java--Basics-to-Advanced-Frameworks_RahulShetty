package TestNG;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
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
	
	
	@Test
	public void secondTest() {
		
		System.out.println("Second Test created");
		
	}
	
	@BeforeTest
	public void executeAtFirst() {
		System.out.println("executeAtFirst of all the methods");
	}
}
