package question183;

public class SingletonLazyThreadNotSafe {
	
	private static SingletonLazyThreadNotSafe instance;
	
	private SingletonLazyThreadNotSafe() {
		try { // 为了验证多线程环境，实例化的时候休眠一段时间
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
