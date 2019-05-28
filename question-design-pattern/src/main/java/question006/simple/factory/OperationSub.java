package question006.simple.factory;

/**
 * @author poldi.chen
 * @className OperationSub
 * @description TODO
 * @date 2019/5/28 18:37
 **/
public class OperationSub extends Operation {

    @Override
    public int getResult() {
        return getValue1() - getValue2();
    }
}
