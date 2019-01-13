package question175;

public class Main {
	
	public static void main(String[] args) throws InterruptedException {
		Resource resource = new Resource();
		MyThread myThread = new MyThread(resource);
		Thread thread = new Thread(myThread);
		thread.start();
		Thread.sleep(1000);
		resource.getResource();
	}

}
