package question060;

public interface MyInterface {

    default void test() { // 加了default关键字，可以有默认实现
        System.out.println("test");
    }

}
