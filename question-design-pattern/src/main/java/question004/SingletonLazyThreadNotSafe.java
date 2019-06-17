package question004;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingletonLazyThreadNotSafe {
	
	private static SingletonLazyThreadNotSafe instance;
	
	private SingletonLazyThreadNotSafe() {
		try { // 为了验证多线程环境，实例化的时候休眠一段时间
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static SingletonLazyThreadNotSafe getInstance() {
		if (instance == null) {
			instance = new SingletonLazyThreadNotSafe();
		}
		return instance;
	}

	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++) {
			service.submit(new Thread(() ->
				System.out.println(SingletonLazyThreadNotSafe.getInstance().hashCode()))
			);
		}
		service.shutdown();
	}

}
