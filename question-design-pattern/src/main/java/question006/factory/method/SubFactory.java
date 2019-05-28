package question006.factory.method;

import question006.simple.factory.Operation;
import question006.simple.factory.OperationSub;

/**
 * @author poldi.chen
 * @className SubFactory
 * @description TODO
 * @date 2019/5/28 19:37
 **/
public class SubFactory implements IFactory {

    @Override
    public Operation createOperation() {
        return new OperationSub();
    }
}
