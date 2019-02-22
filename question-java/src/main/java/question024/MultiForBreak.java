package question024;

public class MultiForBreak {
	
	public static void main(String[] args) { // 跳出多重嵌套循环
		ok: // 任意的标识
			for (int i=0; i<10; i++) {
				for (int j=0; j<10; j++) {
					System.out.println(i + "," + j);
					if (j == 5) {
						break ok; // 跳出多重嵌套循环
					}
				}
			}
	}

}
