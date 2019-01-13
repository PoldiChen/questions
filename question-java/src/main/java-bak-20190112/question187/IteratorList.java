package question187;

import java.util.ArrayList;
import java.util.List;

/**
 * 遍历集合，不要在for循环中每次都调用size()方法获取集合个数
 * @author Administrator
 *
 */
public class IteratorList {
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		for (int i=0; i<100000; i++) {
			list.add(String.valueOf(i));
		}
		long start = System.currentTimeMillis();
		for (int i=0; i<list.size(); i++) { // 先调用一次list.size()得到长度，效率会较高
			System.out.println(list.get(i));
		}
		long end = System.currentTimeMillis();
		System.out.println("cost:" + (end-start));
	}

}
