package question022;

import java.util.Comparator;

/**
 * @author poldi.chen
 * @className ClassToInit
 * @description TODO
 * @date 2019/6/2 12:35
 **/
public class ClassToInit {

    public static final String VAL_STATIC_FINAL = "static final value";
    public static String valStatic = "static value";

    static {
        System.out.println("init ClassToInit");
    }
}
