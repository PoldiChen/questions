package question098;

import java.util.concurrent.atomic.AtomicInteger;

public class CAS {
	
	public static void main(String[] args) {
		AtomicInteger integer = new AtomicInteger(100);
		int a = integer.incrementAndGet(); // ����++����������
		System.out.println(a);
	}

}
