package question202;

import org.hibernate.annotations.Index;

public class OomStackOverflow {
	
	private static int index = 1;
	
	public static void test() {
		index ++;
		int a = 1;
		int b = 1;
		int c = 1;
		int d = 1;
		int e = 1;
		int f = 1;
		int h = 1;
		test();
	}
	
	public static void main(String[] args) {
		try {
			test();
		} catch (Throwable e) { // java.lang.StackOverflowError
			System.out.println(index);
			e.printStackTrace();
		}
		
	}

}
