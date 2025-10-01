package TestNG;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class demo4 {

	@Test
	public void WebLoginHomeLoan() {
		System.out.println("WebLoginHomeLoan method");
		
	}
	
	
	@Test
	public void MobileLoginHomeLoan() {
		
		System.out.println("MobileLoginHomeLoan created");
		
	}
	
	
	@Parameters({"URL"})
	@Test(groups= {"Smoke"})
	public void LoignHomeAPI(String url) {
		System.out.println("LoignHomeAPI called= "+url);
	}
	
}
