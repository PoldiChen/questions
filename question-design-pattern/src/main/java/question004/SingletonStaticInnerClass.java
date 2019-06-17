package question004;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingletonStaticInnerClass {
	
	private static class Holder {
		private static SingletonStaticInnerClass instance = new SingletonStaticInnerClass();
	}
	
	private SingletonStaticInnerClass() {}
	
	public static SingletonStaticInnerClass getInstance() {
		return Holder.instance;
	}

	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++) {
			service.submit(new Thread(() ->
					System.out.println(SingletonStaticInnerClass.getInstance().hashCode()))
			);
		}
	}

}
