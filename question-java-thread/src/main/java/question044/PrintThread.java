package question044;


public class PrintThread implements Runnable {
	
	private String ch;
	private Object self;
	private Object prev;
	
	public PrintThread(String ch, Object self, Object prev) {
		this.ch = ch;
		this.self = self;
		this.prev = prev;
	}

	@Override
	public void run() {
		int count = 10;
		while (count > 0) {
			synchronized (prev) {
				synchronized (self) {
					System.out.println(ch);
					count --;
				}
				self.notify();
			}
			try {
				prev.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
//			count --;
		}
		
		
	}

}
