package question068;

public class InitializerStatic {

    static { // 只在第一次加载类的时候执行
        System.out.println("initialize");
    }

    public static void main(String[] args) {
        InitializerStatic obj1 = new InitializerStatic();
        InitializerStatic obj2 = new InitializerStatic();
        InitializerStatic obj3 = new InitializerStatic();
    }
}
