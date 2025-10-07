package TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class demo2 {

	@Parameters({ "URL", "APIKey" })
	@Test(groups = { "Smoke" })
	public void PersonalLoan(String urlname, String key) {
		System.out.println("PersonalLoan method= " + urlname);
		System.out.println(key);
		
		
	}

	@Test(dataProvider="getData")
	public void EMIcalculation(String username, String password){

		System.out.println("EMIcalculation created");
		System.out.println("Username= "+username+ "Password= "+password);
	}

	@DataProvider
	public Object[][] getData() {
		
		Object[][] data = new Object[3][2];
		
//		data[0][0] ="Username0";
//		data[0][1] ="Password0";
//		
//		data[1][0] ="Username1";
//		data[1][1] ="Password1";
//		
//		data[2][0] ="Username2";
//		data[2][1] ="Password2";
//		
		for(int i=0; i<=2;i++){
			for(int j=0;j<=1;j++) {
				
				if (j == 0) {
	                data[i][j] = "Username" + i;
	            } else {
	                data[i][j] = "Password" + i;
	            }
			}
		}
		
		
		return data;
		
				
	}

}
