package question046;

/**
 * @author poldi.chen
 * @className Test
 * @description TODO
 * @date 2019/3/30 12:18
 **/
public class Test {

    private static String getStr() {
        String s;
        try {
            s = "try";
            return s;
        } catch (Exception e) {
            s = "catch";
            return s;
        } finally {
            s = "finally";
            return s;
        }
//        return s;
    }


    public static void main(String[] args) {
        String s = getStr();
        System.out.println(s);
    }
}
