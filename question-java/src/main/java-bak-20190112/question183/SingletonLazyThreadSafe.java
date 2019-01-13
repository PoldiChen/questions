package question183;

public class SingletonLazyThreadSafe {
	
	private static SingletonLazyThreadSafe instance;
	
	private SingletonLazyThreadSafe() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static synchronized SingletonLazyThreadSafe getInstance() { // �̰߳�ȫ��Ч�ʵ�
		if (instance == null) {
			instance = new SingletonLazyThreadSafe();
		}
		return instance;
	}

}
