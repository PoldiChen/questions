package question004;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingletonHungryStatic {
	
	private static SingletonHungryStatic instance = null;
	
	static { // 和普通的饿汉式没什么区别
		instance = new SingletonHungryStatic();
	}
	
	private SingletonHungryStatic() {}
	
	public static SingletonHungryStatic getInstance() {
		return instance;
	}

	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++) {
			service.submit(new Thread(() ->
					System.out.println(SingletonHungryStatic.getInstance().hashCode()))
			);
		}
		service.shutdown();
	}

}
