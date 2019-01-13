package question156;

import java.io.UnsupportedEncodingException;

public class StringCode {
	
	public static void main(String[] args) {
		String string = "test";
		String string2 = null;
		try {
			string2 = new String(string.getBytes("UTF-8"), "GBK");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		System.out.println(string2);
		
	}

}
