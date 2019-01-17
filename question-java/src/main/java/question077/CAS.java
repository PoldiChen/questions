package question077;

import java.util.concurrent.atomic.AtomicInteger;

public class CAS {
	
	public static void main(String[] args) {
		AtomicInteger integer = new AtomicInteger(100);
		int a = integer.incrementAndGet(); // ´úÌæ++²Ù×÷·û£¿£¿
		System.out.println(a);
	}

}
