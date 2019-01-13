package question032;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CollectionsMethod {
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		List<String> unmodifiableList = (List<String>) Collections.unmodifiableCollection(list);
		List<String> synchronizedList = (List<String>) Collections.synchronizedCollection(list);
	}

}

