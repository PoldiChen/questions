package question004;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingletonDoubleCheckLock {
	
	private static SingletonDoubleCheckLock instance;
	
	private SingletonDoubleCheckLock() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static SingletonDoubleCheckLock getInstance() {
		if (instance == null) {
			synchronized (SingletonDoubleCheckLock.class) {
				if (instance == null) {
					instance = new SingletonDoubleCheckLock();
				}
			}
		}
		return instance;
	}

	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();
		for (int i = 0; i <10; i++) {
			service.submit(new Thread(() ->
					System.out.println(SingletonDoubleCheckLock.getInstance().hashCode()))
			);
		}
		service.shutdown();
	}

}
