package TestNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class demo3 {
	
	
	@BeforeSuite
	public void beforeSuiteMethod() {
		System.out.println("Inside beforeSuiteMethod method\n");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Inside beforeMethod method\n");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("Inside afterMethod method\n");
	}
	
	@Test
	public void WebLoginCarLoan() {
		System.out.println("WebLoginCarLoan method");
		
	}
	
	
	@Test
	public void MobileLoginCarLoan() {
		
		System.out.println("MobileLoginCarLoan created");
		
	}
	
	@Test
	public void MobileSignInCarLoan() {
		
		System.out.println("MobileSignInCarLoan created");
		
	}
	
	@Test
	public void MobileSignOutCarLoan() {
		
		System.out.println("MobileSignOutCarLoan created");
		
	}
	
	
	@Test
	public void APILoignCar() {
		System.out.println("LoignCarAPI called");
	}
	
}
