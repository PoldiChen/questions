package question083.blockingqueue;


public class ThreadProducer implements Runnable {

	@Override
	public void run() {
		int index = 1;
		while (true) {
			String product = "product-" + index++;
			try {
				Thread.sleep(1000);
				QueueProducts.products.put(product);
				System.out.println("produce:"+product);
				System.out.println(QueueProducts.products.size());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
