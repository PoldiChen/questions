package question048;

public class MyThread implements Runnable {
	
	public synchronized void get() {
		System.out.println(Thread.currentThread().getName());
		set(); // 可重入
	}
	
	public synchronized void set() {
		System.out.println(Thread.currentThread().getName());
	}

	@Override
	public void run() {
		get();
	}

}
