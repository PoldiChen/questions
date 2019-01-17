package question084;

public class Chopsticks {
	
	private int index;
	private boolean used;
	
	public Chopsticks(int index) {
		this.index = index;
	}
	
	public synchronized void take() throws InterruptedException {
		while (used) {
			wait();
		}
		used = true;
	}
	
	public synchronized void drop() {
		used = false;
		notifyAll();
	}
	
	@Override
	public String toString() {
		return "chopstick["+index+"]";
	}

}
