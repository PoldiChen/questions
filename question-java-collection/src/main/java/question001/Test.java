package question001;

import java.util.*;

/**
 * @author poldi.chen
 * @className Test
 * @description TODO
 * @date 2019/5/4 14:18
 **/
public class Test {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        ListIterator<String> listIterator = list.listIterator(1); // 从指定位置开始遍历
        while (listIterator.hasPrevious()) { // 向前遍历
            System.out.println(listIterator.previous());
        }
    }

}
