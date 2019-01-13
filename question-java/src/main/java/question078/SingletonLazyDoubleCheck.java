package question100;

public class SingletonLazyDoubleCheck { // Double Check Locking��˫�ؼ������
	
	private static SingletonLazyDoubleCheck instance = null;
	
	private SingletonLazyDoubleCheck() {}
	
	public static SingletonLazyDoubleCheck getInstance() {
		if (instance == null) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (SingletonLazyDoubleCheck.class) { // ��Ҫnewһ��ʵ����ʱ��Ž���ͬ��
				if (instance == null) { // ������һ���鲻�ܱ�֤�̰߳�ȫ
					instance = new SingletonLazyDoubleCheck();
				}
			}
		}
		return instance;
	}

}
