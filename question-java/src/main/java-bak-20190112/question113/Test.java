package question113;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
	
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();
		CountDownLatch latch = new CountDownLatch(5);
		executorService.execute(new ThreadWait(latch));
		executorService.execute(new ThreadCountDown(latch));
		executorService.execute(new ThreadCountDown(latch));
		executorService.execute(new ThreadCountDown(latch));
		executorService.execute(new ThreadCountDown(latch));
		executorService.execute(new ThreadCountDown(latch));
		executorService.shutdown();
	}

}
