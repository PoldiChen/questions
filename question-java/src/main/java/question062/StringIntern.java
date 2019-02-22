package question062;

public class StringIntern {
	

	
	public static void main(String[] args) {
		String str1 = "a";
		String str2 = "b";
		String str3 = str1 + str2;
		
		String str5 = "a" + "b";
		
		String str4 = str3.intern();
		
		System.out.println(str4);
		System.out.println(str3 == str4);
		System.out.println(str5 == str3);
		
		
	}

}

interface Test {
	
	public static void test() {
		//
	}
	
	public void test2();
}
