package question100;

public class SingletonLazySync {
	
	private static SingletonLazySync instance = null;
	
	private SingletonLazySync() {}
	
	public synchronized static SingletonLazySync getInstance() { // ÿ�λ�ȡʵ������Ҫͬ����Ч��̫��
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
