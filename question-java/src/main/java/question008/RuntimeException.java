package question008;

public class RuntimeException {
	
	public static void main(String[] args) {
		int[] a = {1,2,3};
		System.out.println(a[3]); // ArrayIndexOutOfBoundsException;
		
		int b = 1/0; // ArithmeticException
		System.out.println(b);
		
//		Integer c = 1;
//		String s = (String)c;
	}

}
