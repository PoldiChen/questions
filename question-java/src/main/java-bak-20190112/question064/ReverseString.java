package question064;

public class ReverseString {
	
	public static void main(String[] args) {
		String str = "123456";
		System.out.println(reverseString(str));
	}
	
	public static String reverseString(String str) {
		if (str.length() == 1) {
			return str;
		}
		return reverseString(str.substring(1,str.length())) + str.substring(0, 1); // �ڶ�λ��ʼ�����ַ���+��һλ���ַ�
	}

}
