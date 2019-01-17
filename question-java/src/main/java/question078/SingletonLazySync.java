package question078;

public class SingletonLazySync {
	
	private static SingletonLazySync instance = null;
	
	private SingletonLazySync() {}
	
	public synchronized static SingletonLazySync getInstance() { // 每次获取实例都需要同步，效率太低
		if (instance == null) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			instance = new SingletonLazySync();
		}
		return instance;
	}

}
