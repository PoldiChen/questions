package question189;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapRemove {
	
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		map.put("a", "A");
		map.put("b", "B");
		// É¾³ýkeyÎªaµÄÏî
//		forRemove(map);
		iteratorRemove(map);
	}
	
	public static void forRemove(Map<String, String> map) {
		for (Map.Entry<String, String> entry : map.entrySet()) {
			if (entry.getKey() == "a") {
				map.remove(entry.getKey());
			}
		}
	}
	
	public static void iteratorRemove(Map<String, String> map) {
		Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<String, String> entry = iterator.next();
			if (entry.getKey() == "a") {
				iterator.remove();
			}
		}
	}

}
