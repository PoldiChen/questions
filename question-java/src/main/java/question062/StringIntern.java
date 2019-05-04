package question062;

public class StringIntern {

	public static void main(String[] args) {
		String str1 = "a";
		String str2 = "b";
		String str3 = str1 + str2;
		String str5 = "a" + "b";
		String str4 = str3.intern();
		System.out.println(str4); // ab
		System.out.println(str3 == str4); // false
		System.out.println(str5 == str3); // false
	}
}

