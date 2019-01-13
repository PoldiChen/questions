package question129;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableAndFuture {
	
	public static void main(String[] args) {
		Callable<Integer> callable = new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				return new Random().nextInt(100);
			}
		};
		FutureTask<Integer> futureTask = new FutureTask<Integer>(callable);
		new Thread(futureTask).start();
		try {
			Thread.sleep(1000);
			System.out.println(futureTask.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}

}
