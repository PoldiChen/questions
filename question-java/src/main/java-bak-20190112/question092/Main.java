package question092;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
	
	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();
		for (int i=0; i<10; i++) {
			service.execute(new BusinessThread());
		}
		service.shutdown();
	}

}
