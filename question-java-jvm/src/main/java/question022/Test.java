package question022;

/**
 * @author poldi.chen
 * @className Test
 * @description TODO
 * @date 2019/6/2 12:35
 **/
public class Test {

    public static void main(String[] args) {
        ClassToInit[] arr = {}; // 定义类的数组，不会引起初始化
        System.out.println(arr);
        System.out.println(ClassToInit.VAL_STATIC_FINAL); // 引用类的常量，不会引起初始化
        System.out.println(ClassToInit.valStatic); // 引用类的静态变量，会引起类的初始化
        ClassToInit classToInit = new ClassToInit(); // 通过new实例化对象，会引起类的初始化
        System.out.println(classToInit);
    }
}
