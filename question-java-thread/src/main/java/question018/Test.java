package question018;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Test {
	
	public static void main(String[] args) {
		Semaphore semaphore = new Semaphore(3);
		ExecutorService executorService = Executors.newCachedThreadPool();
		for (int i=0; i<5; i++) {
			executorService.execute(new Thread(new MyThread(semaphore), String.valueOf(i)));
		}
		executorService.shutdown();
	}

}
