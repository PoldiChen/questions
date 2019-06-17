package question004;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingletonEnum {
	
	private SingletonEnum() {}
	
	public static SingletonEnum getInstance() {
		return MyEnum.INSTANCE.getInstance();
	}
	
	private static enum MyEnum {
		
		INSTANCE;
		
		private SingletonEnum instance;
		
		private MyEnum() {
			instance = new SingletonEnum();
		}
		
		public SingletonEnum getInstance() {
			return instance;
		}
	}

	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++) {
			service.submit(new Thread(() ->
					System.out.println(SingletonEnum.getInstance().hashCode()))
			);
		}
		service.shutdown();
	}

}
