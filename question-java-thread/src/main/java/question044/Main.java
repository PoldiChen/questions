package question044;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
	
	public static void main(String[] args) throws InterruptedException {
		ExecutorService executorService = Executors.newCachedThreadPool();
		Object a = new Object();
		Object b = new Object();
		Object c = new Object();
		PrintThread threadA = new PrintThread("A", a, c);
		PrintThread threadB = new PrintThread("B", b, a);
		PrintThread threadC = new PrintThread("C", c, b);
		executorService.execute(threadA);
		Thread.sleep(100);
		executorService.execute(threadB);
		Thread.sleep(100);
		executorService.execute(threadC);
		Thread.sleep(100);
		executorService.shutdown();
	}

}
