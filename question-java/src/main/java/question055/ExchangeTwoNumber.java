package question065;

import java.util.concurrent.ConcurrentHashMap;

public class ExchangeTwoNumber {
	
	public static void main(String[] args) {
		int a = 10;
		int b = 20;
		a = a + b;
		b = a - b;
		a = a - b;
		System.out.println(a);
		System.out.println(b);
		
		a = a ^ b; // Œª‘ÀÀ„£¨“ÏªÚ
		b = a ^ b;
		a = a ^ b;
		System.out.println(a);
		System.out.println(b);
	}

}
