package question022;

public class DeadLock implements Runnable {
	
	private Object obj1;
	private Object obj2;
	
	public DeadLock(Object obj1, Object obj2) {
		this.obj1 = obj1;
		this.obj2 = obj2;
	}

	@Override
	public void run() {
		String threadName = Thread.currentThread().getName();
		synchronized (obj1) {
			work();
			synchronized (obj2) {
				work();
			}
		}
		System.out.println(threadName + " finish");
	}
	
	private void work() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
