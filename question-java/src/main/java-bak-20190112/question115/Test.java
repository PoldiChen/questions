package question115;

public class Test {
	
	// ʹ��jdkĿ¼�µ�java visualVM���Լ�⵽����
	public static void main(String[] args) throws InterruptedException {
		Object obj1 = new Object();
		Object obj2 = new Object();
		Thread t1 = new Thread(new DeadLock(obj1, obj2), "t1");
		Thread t2 = new Thread(new DeadLock(obj2, obj1), "t2");
		t1.start();
		Thread.sleep(1000);
		t2.start();
	}

}
