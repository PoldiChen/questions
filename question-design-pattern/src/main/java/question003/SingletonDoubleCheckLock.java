package question003;

public class SingletonDoubleCheckLock {
	
	private static SingletonDoubleCheckLock instance;
	
	private SingletonDoubleCheckLock() {
	}
	
	public static SingletonDoubleCheckLock getInstance() {
		if (instance == null) {
			synchronized (SingletonDoubleCheckLock.class) {
				if (instance == null) {
					instance = new SingletonDoubleCheckLock();
				}
			}
		}
		return instance;
	}

}
