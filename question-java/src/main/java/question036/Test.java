package question036;

import java.lang.reflect.Method;

/**
 * @author poldi.chen
 * @className Test
 * @description TODO
 * @date 2019/5/4 10:50
 **/
public class Test {

    @MyAnnotation(author = "poldi chen", priority = MyAnnotation.Priority.LOW, status = MyAnnotation.Status.NOT_STARTED)
    public void myMethod() {
        System.out.println("myMethod");
    }

    public static void main(String[] args) {
        Class test = Test.class;
        Method[] methods = test.getMethods();
//        System.out.println(methods);
        for (Method method: methods) {
//            System.out.println(method);
            MyAnnotation myAnnotation = method.getAnnotation(MyAnnotation.class);
            if (myAnnotation == null) {
                continue;
            }
            System.out.println(myAnnotation.author());
            System.out.println(myAnnotation.priority());
            System.out.println(myAnnotation.status());
        }
    }

}
