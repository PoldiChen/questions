package question138;

public class StackOverflowErrorTest {
	
	private static int index = 1;
	
	public void call() {
		index ++;
		call();
	}
	
	public static void main(String[] args) {
		StackOverflowErrorTest stackOverflowErrorTest = new StackOverflowErrorTest();
		try {
			stackOverflowErrorTest.call();
		} catch (Throwable e) { // ����exception��StackOverflowError��OutOfMemoryError������exception������
			System.out.println("depth:"+index);
			e.printStackTrace();
		}
	}

}
