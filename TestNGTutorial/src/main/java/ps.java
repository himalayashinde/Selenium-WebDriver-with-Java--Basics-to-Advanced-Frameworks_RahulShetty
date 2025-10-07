import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class ps {

		// TODO Auto-generated method stub

		public void doThis() {
			System.out.println("I am inside do this from parent");
		}

		
		@BeforeMethod
		public void beforeRun() {
			System.out.println("Before Test Run");
		}
		
		
		@AfterMethod
		public void AfterRun() {
			System.out.println("AfterRun Test closed");
		}
		
}
