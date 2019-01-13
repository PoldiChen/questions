package question116;

public class ThreadB implements Runnable {

	@Override
	public void run() {
		System.out.println("ThreadB start");
		Thread threadA = new Thread(new ThreadA());
		threadA.start();
		try {
			threadA.join(); // 等待线程A执行完，本线程才继续执行
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		try {
			Thread.sleep(Common.getMilis());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("ThreadB finish");
	}
}
