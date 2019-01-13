package question100;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test implements Runnable {

	@Override
	public void run() {
//		SingletonLazyUnsafe instance = SingletonLazyUnsafe.getInstance();
//		SingletonHungry instance = SingletonHungry.getInstance();
//		SingletonLazySync instance = SingletonLazySync.getInstance();
		SingletonLazyDoubleCheck instance = SingletonLazyDoubleCheck.getInstance();
		System.out.println(instance.hashCode());
	}
	
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();
		for (int i=0; i<10; i++) {
			executorService.execute(new Test());
		}
		executorService.shutdown();
	}

}
