package question065;

// synchronized是可重入锁
public class SynchronizedTest {
	
	synchronized void setA() throws Exception {
		System.out.println("setA");
		Thread.sleep(1000);
		setB();
	}
	
	synchronized void setB() throws Exception {
		System.out.println("setB");
		Thread.sleep(1000);
	}
	
	public static void main(String[] args) throws Exception {
		SynchronizedTest synchronizedTest = new SynchronizedTest();
		synchronizedTest.setA();
	}

}
