package question004;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingletonHungryClassLoader {
	
	// 基于classloader机制避免了多线程的同步问题
	private static SingletonHungryClassLoader instance = new SingletonHungryClassLoader();
	
	private SingletonHungryClassLoader() {}
	
	public static SingletonHungryClassLoader getInstance() {
		return instance;
	}

	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++) {
			service.submit(new Thread(() ->
					System.out.println(SingletonHungryClassLoader.getInstance().hashCode()))
			);
		}
	}

}
