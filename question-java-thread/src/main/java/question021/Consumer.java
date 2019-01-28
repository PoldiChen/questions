package question021;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Consumer implements Runnable {
	
	private Lock lock;
	private Condition notFull;
	private Condition notEmpty;
	
	public Consumer(Lock lock, Condition notFull, Condition notEmpty) {
		this.lock = lock;
		this.notFull = notFull;
		this.notEmpty = notEmpty;
	}

	public void run() {
		while (true) {
			lock.lock();
			try {
				while (Products.products.isEmpty()) {
					notEmpty.await();
				}
				String product = Products.products.poll();
				System.out.println(hashCode()+"-consume:"+product);
				Thread.sleep(getMillis());
				notFull.signalAll();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
		}
	}
	
	private int getMillis() {
		Random random = new Random();
		return random.nextInt(5000);
	}

}
