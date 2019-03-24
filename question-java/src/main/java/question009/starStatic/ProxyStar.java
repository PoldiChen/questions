package question009.starStatic;

public class ProxyStar implements IStar {

    private IStar star;

    public ProxyStar(IStar star) {
        this.star = star;
    }

    @Override
    public void sing() {
        System.out.println("before singing");
        this.star.sing();
        System.out.println("after singing");
    }
}
