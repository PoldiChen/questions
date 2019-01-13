package question110.waitnotify;

import java.util.Random;

public class Helper {
	
	public static int getSleepMills() {
		Random random = new Random();
		int num = random.nextInt(10000);
		return num;
	}
	
	public static void printCount() {
		System.out.println(Products.products.size());
	}
	
	public static void main(String[] args) {
		System.out.println(getSleepMills());
	}

}
