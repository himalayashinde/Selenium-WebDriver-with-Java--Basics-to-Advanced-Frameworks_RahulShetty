import org.testng.annotations.Test;

public class ps1 extends ps{

	@Test
	public void testRun() {
		int a = 3;
		
		ps2 ps2 = new ps2(a);
		
		doThis();
		
		System.out.println("Increment= "+ps2.increment());
		
		System.out.println("Decrement= "+ps2.decrement());
		
		//ps3 ps3= new ps3(a);
		System.out.println("Multiply by 2= "+ ps2.MultiplywithTwo());
		System.out.println("Multiply by 3 = "+ ps2.MultiplywithThree());
	}
	
}
