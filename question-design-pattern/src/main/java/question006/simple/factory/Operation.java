package question006.simple.factory;

/**
 * @author poldi.chen
 * @className Operation
 * @description TODO
 * @date 2019/5/28 18:33
 **/
public abstract class Operation {

    private int value1;
    private int value2;

    public int getValue1() {
        return value1;
    }

    public void setValue1(int value1) {
        this.value1 = value1;
    }

    public int getValue2() {
        return value2;
    }

    public void setvalue2(int value2) {
        this.value2 = value2;
    }

    public abstract int getResult();

}
