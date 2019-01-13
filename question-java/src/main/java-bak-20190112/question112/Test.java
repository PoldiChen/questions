package question112;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
	
	public static void main(String[] args) {
		Chopsticks[] chopsticks = new Chopsticks[5];
		for (int i=0; i<5; i++) {
			chopsticks[i] = new Chopsticks(i);
		}
		ExecutorService executorService = Executors.newCachedThreadPool();
		for (int i=0; i<5; i++) {
			executorService.execute(new Philosopher(chopsticks[i], chopsticks[(i+1)%5], i)); // 分配两根筷子
		}
		executorService.shutdown();
	}

}
