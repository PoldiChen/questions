package question018;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class MyThread implements Runnable {
	
	private Semaphore semaphore;
	
	public MyThread(Semaphore semaphore) {
		this.semaphore = semaphore;
	}

	public void run() {
		while (true) {
			try {
				semaphore.acquire();
				System.out.println("["+Thread.currentThread().getName()+"]acquire the semaphore");
				Thread.sleep(getMillis());
				System.out.println("["+Thread.currentThread().getName()+"]release the semaphore");
				semaphore.release();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	private int getMillis() {
		Random random = new Random();
		return random.nextInt(3000);
	}

}
