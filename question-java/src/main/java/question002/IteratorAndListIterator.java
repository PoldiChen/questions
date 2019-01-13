package question002;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

/**
 * Iterator��ListIterator������
 * @author Administrator
 *
 */
public class IteratorAndListIterator {
	
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		set.add("a");
		set.add("b");
		set.add("c");
		Iterator<String> iterator = set.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		List<String> list = new ArrayList<String>();
		list.add("aa");
		list.add("bb");
		list.add("cc");
		ListIterator<String> listIterator = list.listIterator();
		while (listIterator.hasNext()) {
			String nextVal = listIterator.next();
			if (nextVal.equals("aa")) {
				listIterator.set("aaa"); // �����滻Ԫ��
				listIterator.add("aaaa"); // �������Ԫ��
				break;
			}
		}
		System.out.println(list);
	}
	

}
