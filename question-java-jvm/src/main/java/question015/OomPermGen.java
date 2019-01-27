package question015;

import java.util.ArrayList;
import java.util.List;

public class OomPermGen {
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		int index = 1;
		while (true) {
			list.add(String.valueOf(index++).intern());
		}
	}

}
