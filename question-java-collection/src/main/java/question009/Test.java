package question009;

import java.util.*;

/**
 * @author poldi.chen
 * @className Test
 * @description TODO
 * @date 2019/5/4 14:58
 **/
public class Test {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
//        list.add("c");

        for (String s : list) {
            System.out.println(s);
            list.remove(1);
        }

    }

}
