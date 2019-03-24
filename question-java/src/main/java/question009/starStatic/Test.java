package question009.starStatic;

public class Test {

    public static void main(String[] args) {
        IStar realStar = new RealStar();
        IStar proxyStar = new ProxyStar(realStar);
        proxyStar.sing();
    }
}
