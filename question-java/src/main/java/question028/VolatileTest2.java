package question028;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VolatileTest2 {
	
	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();
		Numbers numbers = new Numbers();
		for (int i=0; i<200; i++) {
			service.execute(new Thread(new ThreadPrint(numbers)));
			service.execute(new Thread(new ThreadChange(numbers)));
		}
		service.shutdown();
	}
}

class Numbers {
	private int a = 1;
	private int b = 2;
	
	public void change() {
		a = 3;
		b = a;
	}
	
	public void print() {
		System.out.println("a="+a+";b="+b);
	}
}

class ThreadChange implements Runnable {
	
	private Numbers numbers;
	
	public ThreadChange(Numbers numbers) {
		this.numbers = numbers;
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		numbers.change();
	}
}

class ThreadPrint implements Runnable {
	
	private Numbers numbers;
	
	public ThreadPrint(Numbers numbers) {
		this.numbers = numbers;
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		numbers.print();
	}
}

