package question187;

import java.util.ArrayList;
import java.util.List;

/**
 * �������ϣ���Ҫ��forѭ����ÿ�ζ�����size()������ȡ���ϸ���
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
		for (int i=0; i<list.size(); i++) { // �ȵ���һ��list.size()�õ����ȣ�Ч�ʻ�ϸ�
			System.out.println(list.get(i));
		}
		long end = System.currentTimeMillis();
		System.out.println("cost:" + (end-start));
	}

}
