package question012;

import java.util.WeakHashMap;

/**
 * @author poldi.chen
 * @className Test
 * @description TODO
 * @date 2019/6/27 10:12
 **/
public class Test {

    public static void main(String[] args) {
        WeakHashMap<String, String> weakHashMap = new WeakHashMap<>();
        weakHashMap.put("my_name", "chenxihong");
        System.out.println(weakHashMap.get("my_name"));
        test(null);
    }

    private static void test(Integer i) {
        System.out.println(i);
    }

}
