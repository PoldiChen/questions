package question078;

public class SingletonLazyUnsafe {
	
	private static SingletonLazyUnsafe instance = null;
	
	private SingletonLazyUnsafe() {}
	
	public static SingletonLazyUnsafe getInstance() {
		if (instance == null) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			instance = new SingletonLazyUnsafe();
		}
		return instance;
	}

}

