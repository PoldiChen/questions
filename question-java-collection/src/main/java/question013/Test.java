package question013;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author poldi.chen
 * @className Test
 * @description TODO
 * @date 2019/5/4 16:36
 **/
public class Test {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("a");
        list.add("b");
        Set<String> hashSet = new HashSet<>(list);
        for (String s : hashSet) {
            System.out.println(s);
        }
    }


}
