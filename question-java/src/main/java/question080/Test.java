package question104;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
	
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();
		executorService.execute(new ThreadNumber());
		executorService.execute(new ThreadChar());
		executorService.shutdown();
	}

}
