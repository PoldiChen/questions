package question183;

public class MyThread implements Runnable {

	@Override
	public void run() {
//		SingletonEnum.INSTANCE;
		SingletonDoubleCheckLock singleton = SingletonDoubleCheckLock.getInstance();
		System.out.println(singleton.hashCode());
	}

}
