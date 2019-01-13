package question113;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class ThreadCountDown implements Runnable {
	
	private CountDownLatch latch;
	
	public ThreadCountDown(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {
		System.out.println("ThreadCountDown-"+hashCode()+" start");	
		try {
			Thread.sleep(getSleepMillis());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		latch.countDown();
		System.out.println("ThreadCountDown-"+hashCode()+" finish");
		
	}
	
	private int getSleepMillis() {
		Random random = new Random();
		int millis = random.nextInt(8000);
		return millis;
	}

}
