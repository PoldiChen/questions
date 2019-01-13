package question041;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListRemove {
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d"); // TODO:��Ԫ�ظ����йأ���������4��Ԫ�ز������쳣����
		list.add("e");
		list.add("f");
		list.add("g");
//		listRemove(list);
		iteratorRemove(list);
	}
	
	public static void listRemove(List<String> list) {
		for (String string : list) { // ���ܻ��׳�ConcurrentModificationException
			if (string.equals("b")) {
				list.remove(string);
			}
		}
		System.out.println(list);
	}
	
	public static void iteratorRemove(List<String> list) {
		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext()) {
			String string = iterator.next();
			if (string.equals("c")) {
				iterator.remove();
			}
		}
		System.out.println(list);
	}

}
