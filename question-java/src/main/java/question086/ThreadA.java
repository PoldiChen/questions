package question086;

public class ThreadA implements Runnable {

	@Override
	public void run() {
		System.out.println("ThreadA start");
		try {
			Thread.sleep(Common.getMilis());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("ThreadA finish");
	}
}
