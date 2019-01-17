package question083.waitnotify;

public class ThreadConsumer implements Runnable {

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(Helper.getSleepMills());
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			synchronized (Products.products) {
				while (Products.products.isEmpty()) {
					System.out.println("empty,wait to consume.");
					try {
						Products.products.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				String product = Products.products.poll();
				System.out.println("thread["+hashCode()+"]consume:"+product);
				Helper.printCount();
				Products.products.notifyAll();
			}
		}
	}

}
