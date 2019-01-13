package question090;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MyThreadLocal<T> {
	
	private Map<Thread, T> map = Collections.synchronizedMap(new HashMap<Thread, T>());
	
	public void set(T value) {
		map.put(Thread.currentThread(), value);
	}
	
	public T get() {
		return map.get(Thread.currentThread());
	}
	
	public void remove() {
		map.remove(Thread.currentThread());
	}

}
