package question083.waitnotify;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
	
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();
		executorService.execute(new ThreadProducer());
		executorService.execute(new ThreadConsumer());
		executorService.execute(new ThreadConsumer());
		executorService.execute(new ThreadConsumer());
	}

}
