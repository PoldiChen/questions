package question144;

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

}
