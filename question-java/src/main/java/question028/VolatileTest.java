package question028;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VolatileTest implements Runnable {
	
	private static volatile Long long1 = 0L;
	
	private final Long val;
	
	public VolatileTest(Long val) {
		this.val = val;
	}

	@Override
	public void run() {
		while (!Thread.interrupted()) {
			long1 = this.val;
			System.out.println(long1);
		}
	}
	
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();
		for (int i=0; i<20; i++) {
			executorService.execute(new VolatileTest((long) i));
		}
		executorService.shutdown();
	}

}
