package question012;

public class ThreadChar implements Runnable {

	public void run() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		int index = 0;
		while (index < 26) {
			synchronized (Lock.LOCK) {
				try {
					Lock.LOCK.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				print(index);;
				index++;
				Lock.LOCK.notify();
			}
		}
	}
	
	private void print(int index) {
		char first = 'A';
		int firstAscii = first;
		System.out.println((char)(firstAscii+index));
	}

}
