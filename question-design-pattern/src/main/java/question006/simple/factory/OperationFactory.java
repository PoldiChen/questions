package question006.simple.factory;

/**
 * @author poldi.chen
 * @className OperationFactory
 * @description TODO
 * @date 2019/5/28 19:31
 **/
public class OperationFactory {

    public static Operation createOperation(String operator) {
        Operation operation = null;
        switch (operator) {
            case "+":
                operation = new OperationAdd();
                break;
            case "-":
                operation = new OperationSub();
                break;
        }
        return operation;
    }

}
