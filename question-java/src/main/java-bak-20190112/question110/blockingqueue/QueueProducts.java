package question110.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class QueueProducts {
	
	public static final BlockingQueue<String> products = new ArrayBlockingQueue<>(10);

}
