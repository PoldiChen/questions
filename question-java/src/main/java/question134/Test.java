package question173;

public class Test {
	
	public static void main(String[] args) {
		char[] charArr = {'a', 'b', 'c'};
		String s1 = charArr.toString();
		String s2 = new String(charArr);
		String s3 = String.valueOf(charArr);
		System.out.println(s1); // ���[C@52e922��Ԫ��Ϊchar�����飿����
		System.out.println(s2);	
		System.out.println(s3);
	}

}
