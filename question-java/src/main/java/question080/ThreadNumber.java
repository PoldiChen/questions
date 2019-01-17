package question080;

public class ThreadNumber implements Runnable {

	@Override
	public void run() {
		try {
			Thread.sleep(200);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		int index = 0;
		while (index < 52) {
			synchronized (Lock.LOCK) {
				print(index);
				index++;
				if (index%2 == 0 && index != 0) {
					Lock.LOCK.notify();
					try {
						Lock.LOCK.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	private void print(int index) {
		System.out.println(index+1);
	}

}
