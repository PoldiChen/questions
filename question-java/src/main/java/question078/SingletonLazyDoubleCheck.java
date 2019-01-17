package question078;

public class SingletonLazyDoubleCheck { // Double Check Locking，双重检查锁定
	
	private static SingletonLazyDoubleCheck instance = null;
	
	private SingletonLazyDoubleCheck() {}
	
	public static SingletonLazyDoubleCheck getInstance() {
		if (instance == null) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (SingletonLazyDoubleCheck.class) { // 需要new一个实例的时候才进行同步
				if (instance == null) { // 不加这一层检查不能保证线程安全
					instance = new SingletonLazyDoubleCheck();
				}
			}
		}
		return instance;
	}

}
