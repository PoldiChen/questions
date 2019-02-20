package question065;

import java.util.concurrent.atomic.AtomicReference;

// 自旋锁的实现
public class SpinLockTest {
	
	private AtomicReference<Thread> cas = new AtomicReference<>();
	
	public void lock() {
		Thread current = Thread.currentThread();
		while (!cas.compareAndSet(null, current)) {
			// doing something
		}
	}
	
	public void unlock() {
		Thread current = Thread.currentThread();
		cas.compareAndSet(current, null);
	}

}
