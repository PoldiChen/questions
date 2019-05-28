package question006.simple.factory;

/**
 * @author poldi.chen
 * @className OperationAdd
 * @description TODO
 * @date 2019/5/28 18:36
 **/
public class OperationAdd extends Operation {

    @Override
    public int getResult() {
        return getValue1() + getValue2();
    }
}
