package question004;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingletonLazyThreadSafe {
	
	private static SingletonLazyThreadSafe instance;
	
	private SingletonLazyThreadSafe() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static synchronized SingletonLazyThreadSafe getInstance() { // 线程安全但效率低
		if (instance == null) {
			instance = new SingletonLazyThreadSafe();
		}
		return instance;
	}

	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++) {
			service.submit(new Thread(() ->
					System.out.println(SingletonLazyThreadSafe.getInstance().hashCode()))
			);
		}
		service.shutdown();
	}

}
