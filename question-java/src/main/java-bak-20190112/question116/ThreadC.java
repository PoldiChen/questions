package question116;

public class ThreadC implements Runnable {

	@Override
	public void run() {
		System.out.println("ThreadC start");
		Thread threadB = new Thread(new ThreadB());
		threadB.start();
		try {
			threadB.join(); // �ȴ��߳�B��ִ���걾�̲߳ż���ִ��
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
