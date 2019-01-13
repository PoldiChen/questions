package question202;

import java.util.ArrayList;
import java.util.List;

// ���ڴ����
// -Xms20m                          ��С���ڴ�
// -Xmx20m                          �����ڴ�
// -XX:+HeapDumpOnOutOfMemoryError  ��ӡ���߳��ļ�
public class OutOfMemoryErrorTest {
	
	static class OOMObject {}
	
	public static void main(String[] args) {
		List<OOMObject> list = new ArrayList<OutOfMemoryErrorTest.OOMObject>();
		while (true) {
			list.add(new OOMObject()); // java.lang.OutOfMemoryError: Java heap space
		}
	}

}
