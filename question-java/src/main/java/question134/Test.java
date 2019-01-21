package question134;

public class Test {
	
	public static void main(String[] args) {
		char[] charArr = {'a', 'b', 'c'};
		String s1 = charArr.toString();
		String s2 = new String(charArr);
		String s3 = String.valueOf(charArr);
		System.out.println(s1); // 输出[C@52e922，元素为char的数组？？？
		System.out.println(s2);	
		System.out.println(s3);
	}

}
