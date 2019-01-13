package question117;

import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class DataObj {
	
	private Object data = null;
	private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
	
	public void get() {
		readWriteLock.readLock().lock();
		try {
			System.out.println("[" + Thread.currentThread().getName() + "] ready to read");
			Thread.sleep(new Random().nextInt(2000));
			System.out.println("[" + Thread.currentThread().getName() + "] read data: " + data);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			readWriteLock.readLock().unlock();
		}
	}
	
	public void put(Object data) {
		readWriteLock.writeLock().lock();
		try {
			System.out.println("[" + Thread.currentThread().getName() + "] ready to write");
			Thread.sleep(new Random().nextInt(2000));
			this.data = data;
			System.out.println("[" + Thread.currentThread().getName() + "] write data:" + data);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			readWriteLock.writeLock().unlock();
		}
	}

}
