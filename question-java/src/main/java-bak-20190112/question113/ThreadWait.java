package question113;

import java.util.concurrent.CountDownLatch;

public class ThreadWait implements Runnable {
	
	private CountDownLatch latch;
	
	public ThreadWait(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {
		System.out.println("ThreadWait-"+hashCode()+" start");
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("ThreadWait-"+hashCode()+" end");
	}

}
