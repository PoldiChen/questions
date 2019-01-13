package question110.waitnotify;

public class ThreadProducer implements Runnable {

	@Override
	public void run() {
		int index = 1;
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (Products.products) {
				while (Products.products.size() >= Products.MAX) {
					System.out.println("full,wait to produce");
					try {
						Products.products.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("produce:product-"+index);
				Products.products.add("product-"+index);
				Helper.printCount();
				index++;
				Products.products.notifyAll();
			}
		}
	}

}
