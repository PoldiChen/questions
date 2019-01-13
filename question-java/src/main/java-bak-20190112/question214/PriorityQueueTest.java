package question214;

import java.util.Iterator;
import java.util.PriorityQueue;

public class PriorityQueueTest {
	
	public static void main(String[] args) {
		PriorityQueue<String> queue = new PriorityQueue<String>();
		queue.add("b");
		queue.add("a");
		queue.add("c");
		Iterator<String> iterator = queue.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next()); // Êä³ö a b c
		}
	}

}
