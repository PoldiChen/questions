package question003;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
	
	public static void main(String[] args) {
//		VolatileSingleton singleton = VolatileSingleton.getInstance();
//		System.out.println(singleton.hashCode());
		ExecutorService service = Executors.newCachedThreadPool();
		for (int i=0; i<2; i++) {
			service.execute(new Thread(new MyThread()));
		}
		service.shutdown();
	}

}
