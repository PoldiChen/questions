package question202;

import java.util.ArrayList;
import java.util.List;

// 堆内存溢出
// -Xms20m                          最小堆内存
// -Xmx20m                          最大堆内存
// -XX:+HeapDumpOnOutOfMemoryError  打印出线程文件
public class OutOfMemoryErrorTest {
	
	static class OOMObject {}
	
	public static void main(String[] args) {
		List<OOMObject> list = new ArrayList<OutOfMemoryErrorTest.OOMObject>();
		while (true) {
			list.add(new OOMObject()); // java.lang.OutOfMemoryError: Java heap space
		}
	}

}
