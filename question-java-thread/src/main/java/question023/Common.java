package question023;

import java.util.Random;

public class Common {
	
	public static int getMilis() {
		Random random = new Random();
		int millis = random.nextInt(3000);
		return millis;
	}

}
