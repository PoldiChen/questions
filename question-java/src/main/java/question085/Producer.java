package question085;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Producer implements Runnable {
	
	private Lock lock;
	private Condition notFull;
	private Condition notEmpty;
	
	public Producer(Lock lock, Condition notFull, Condition notEmpty) {
		this.lock = lock;
		this.notFull = notFull;
		this.notEmpty = notEmpty;
	}

	@Override
	public void run() {
		int index = 1;
		while (true) {
			lock.lock();
			try {
				while (Products.products.size() >= Products.MAX) {
					notFull.await();
				}
				String product = "product-"+(index++);
				Products.products.add(product);
				System.out.println(hashCode()+"-produce:"+product);
				Thread.sleep(1000);
				notEmpty.signalAll();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
		}
		
	}

}
