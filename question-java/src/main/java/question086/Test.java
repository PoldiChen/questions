package question116;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
	
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();
//		executorService.execute(new ThreadA());
//		executorService.execute(new ThreadB());
		executorService.execute(new ThreadC());
		executorService.shutdown();
	}

}
