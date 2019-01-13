package question039;

import java.util.ArrayList;
import java.util.List;

public class RuntimeTest {
	
	public static void main(String[] args) {
		Runtime runtime = Runtime.getRuntime();
		long freeMemory = runtime.freeMemory(); // 剩余字节数
		long totalMemory = runtime.totalMemory(); // 总字节数
		long maxMemory = runtime.maxMemory(); // 最大字节数？？
		System.out.println(freeMemory/1024/1024);
		System.out.println(totalMemory/1024/1024);
		System.out.println(maxMemory/1024/1024);
	}

}
