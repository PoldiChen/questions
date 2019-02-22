package question048;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 比较高效的遍历HashMap的方法
 * @author Administrator
 *
 */
public class IteratorHashMap {
	
	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<>();
		map.put("a", "A");
		map.put("b", "B");
		Set<Map.Entry<String, String>> entrySet = map.entrySet();
		Iterator<Map.Entry<String, String>> iterator = entrySet.iterator();
		while (iterator.hasNext()) {
			Map.Entry<String, String> entry = iterator.next();
			System.out.println("key:" + entry.getKey());
			System.out.println("value:" + entry.getValue());
		}
	}

}
