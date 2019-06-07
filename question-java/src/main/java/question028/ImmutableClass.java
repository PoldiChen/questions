package question028;

/**
 * @author poldi.chen
 * @className ImmutableClass
 * @description TODO
 * @date 2019/6/7 12:38
 **/
public final class ImmutableClass { // 类用final修饰

    private final String var1 = "var1"; // 用final修饰

    private OuterClass outerClass;

    public OuterClass getOuterClass() {
        return (OuterClass) outerClass.clone(); // 不直接返回成员对象，返回成员对象的clone
    }

}

class OuterClass implements Cloneable {

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        } finally {
            return null;
        }
    }
}
