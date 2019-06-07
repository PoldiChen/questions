package question009.starDynamic;

public class Test {

    public static void main(String[] args) {
        IStar realStar = new RealStar();
        IStar proxy = (IStar) new JdkProxyHandler(realStar).getProxyInstance();
        proxy.sing();
        proxy.dance();
    }
}
