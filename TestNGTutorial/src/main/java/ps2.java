
public class ps2 extends ps3 {

	int a;
	
	public ps2(int a2) {
		// TODO Auto-generated constructor stub
		super(a2);
		this.a = a2;
		
	}

	public int increment() {
		
		a = a+1;
		return a;
	}
	
public int decrement() {
		
		a = a-1;
		return a;
	}
}
