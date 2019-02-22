package question068;

public class InitializerInstance {

    {
        System.out.println("initialize"); // 每次创建类的实例时都会执行
    }

    public static void main(String[] args) {
        InitializerInstance obj1 = new InitializerInstance();
        InitializerInstance obj2 = new InitializerInstance();
        InitializerInstance obj3 = new InitializerInstance();
    }
}
