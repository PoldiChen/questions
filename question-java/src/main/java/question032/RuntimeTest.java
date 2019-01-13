package question039;

import java.util.ArrayList;
import java.util.List;

public class RuntimeTest {
	
	public static void main(String[] args) {
		Runtime runtime = Runtime.getRuntime();
		long freeMemory = runtime.freeMemory(); // ʣ���ֽ���
		long totalMemory = runtime.totalMemory(); // ���ֽ���
		long maxMemory = runtime.maxMemory(); // ����ֽ�������
		System.out.println(freeMemory/1024/1024);
		System.out.println(totalMemory/1024/1024);
		System.out.println(maxMemory/1024/1024);
	}

}
