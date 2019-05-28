package question006.factory.method;

import question006.simple.factory.Operation;

/**
 * @author poldi.chen
 * @className Test
 * @description TODO
 * @date 2019/5/28 19:37
 **/
public class Test {

    public static void main(String[] args) {
        IFactory factoryAdd = new AddFactory();
        Operation operationAdd = factoryAdd.createOperation();
        operationAdd.setValue1(2);
        operationAdd.setvalue2(3);
        System.out.println(operationAdd.getResult());
    }
}
