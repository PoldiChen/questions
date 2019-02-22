package question004;

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
		} catch (Throwable e) { // 不是exception，StackOverflowError和OutOfMemoryError都不是exception的子类
			System.out.println("depth:"+index);
			e.printStackTrace();
		}
	}

}
