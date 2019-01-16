package question018;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OutOfMemory {
	
	public static void main(String[] args) {
		stackOverFlow();
	}
	
	public static void stackOverFlow() {
		stackOverFlow(); // java.lang.StackOverflowError
	}
	
	public static void heapSpace() {
		List<UUID> list = new ArrayList<UUID>();
		while (true) {
			list.add(UUID.randomUUID()); // java.lang.OutOfMemoryError: Java heap space
		}
	}

}
