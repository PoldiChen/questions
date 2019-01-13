package question007;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class HashSetAndTreeSet {
	
	public static void main(String[] args) {
		Set<Integer> hashSet = new HashSet<>();
		Set<Integer> treeSet = new TreeSet<>();
		Random random = new Random(47);
		for (int i=0; i<10; i++) {
			int num = random.nextInt(30);
			System.out.println(num);
			hashSet.add(num);
			treeSet.add(num);
		}
		System.out.println(hashSet); // 无序，且和插入顺序无关
		System.out.println(treeSet); // 有序
	}

}
