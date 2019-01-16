package question043;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class BitCalculate {
	
	public static void main(String[] args) {
	
		byte b1 = -128; // 1000,0000
		byte b2 = -128;
		byte result = (byte) (b1+b2);
		System.out.println(result); // 0  1,0000,0000溢出的一位去掉，即0000,0000
		
		int i1 = Integer.MAX_VALUE; // 0111,1111,1111,1111,1111,1111,1111,1111
		int i2 = Integer.MAX_VALUE;
		System.out.println(i1+i2); // -2   1111,1111,1111,1111,1111,1111,1111,1110 -2的二进制表示
		
		System.out.println(Integer.MAX_VALUE); // 2,147,483,647

	}

}
