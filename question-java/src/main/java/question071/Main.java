package question071;

/**
 * @author poldi.chen
 * @className Main
 * @description TODO
 * @date 2019/3/24 9:42
 **/
public class Main {

    public static void main(String[] args) {
        Integer a1 = 20;
        Integer a2 = 20;
        System.out.println(a1 == a2); // true

        Integer a3 = 200;
        Integer a4 = 200;
        System.out.println(a3 == a4); // false

        String s1 = "abc";
        String s2 = "abc";
        System.out.println(s1 == s2); // true
    }
}
