package question110.blockingqueue;

import java.util.Random;

public class ThreadConsumer implements Runnable {

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(getSleepMillis());
				String product = QueueProducts.products.take();
				System.out.println("["+hashCode()+"]consume:"+product);
				System.out.println(QueueProducts.products.size());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private int getSleepMillis() {
		Random random = new Random();
		int millis = random.nextInt(8000);
		return millis;
	}

}
