package question114;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test {
	
	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();
		Lock lock = new ReentrantLock();
		Condition notFull = lock.newCondition();
		Condition notEmpty = lock.newCondition();
		service.execute(new Producer(lock, notFull, notEmpty));
		service.execute(new Producer(lock, notFull, notEmpty));
		service.execute(new Consumer(lock, notFull, notEmpty));
		service.execute(new Consumer(lock, notFull, notEmpty));
		service.execute(new Consumer(lock, notFull, notEmpty));
		service.shutdown();
	}

}
