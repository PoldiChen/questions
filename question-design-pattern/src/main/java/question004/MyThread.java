package question004;

public class MyThread implements Runnable {

	@Override
	public void run() {
//		SingletonEnum.INSTANCE;
//		SingletonDoubleCheckLock singleton = SingletonDoubleCheckLock.getInstance();
//		System.out.println(singleton.hashCode());

		SingletonLazyThreadNotSafe singleton = SingletonLazyThreadNotSafe.getInstance();
		System.out.println(singleton.hashCode());
	}

}
