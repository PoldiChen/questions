package question183;

public class SingletonLazyThreadNotSafe {
	
	private static SingletonLazyThreadNotSafe instance;
	
	private SingletonLazyThreadNotSafe() {
		try { // Ϊ����֤���̻߳�����ʵ������ʱ������һ��ʱ��
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static SingletonLazyThreadNotSafe getInstance() {
		if (instance == null) {
			instance = new SingletonLazyThreadNotSafe();
		}
		return instance;
	}

}
