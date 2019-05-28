package question006.factory.method;

import question006.simple.factory.Operation;
import question006.simple.factory.OperationAdd;

/**
 * @author poldi.chen
 * @className AddFactory
 * @description TODO
 * @date 2019/5/28 19:36
 **/
public class AddFactory implements IFactory {

    @Override
    public Operation createOperation() {
        return new OperationAdd();
    }
}
