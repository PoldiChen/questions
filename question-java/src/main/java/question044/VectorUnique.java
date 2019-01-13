package question051;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Vector;


public class VectorUnique {
	
	public static void main(String[] args) {
		Vector<String> vector = new Vector<String>();
		vector.add("a");
		vector.add("b");
		vector.add("b");
		
		List<String> arrayList = new ArrayList<>(vector);
		List<String> linkedList = new LinkedList<>(vector);
		
		Set<String> set1 = new HashSet<>(vector); // 将Vector中重复的元素去除
		System.out.println(set1);
		
		Set<String> set2 = new HashSet<>(arrayList); // 将ArrayList中重复的元素去除
		System.out.println(set2);
		
		Set<String> set3 = new HashSet<>(linkedList); // 将LinkedList中重复的元素去除
		System.out.println(set3);
	}

}
