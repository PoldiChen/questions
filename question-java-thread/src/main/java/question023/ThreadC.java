package question023;

public class ThreadC implements Runnable {

	@Override
	public void run() {
		System.out.println("ThreadC start");
		Thread threadB = new Thread(new ThreadB());
		threadB.start();
		try {
			threadB.join(); // 等待线程B，执行完本线程才继续执行
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		try {
			Thread.sleep(Common.getMilis());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("ThreadC finish");
	}

}
