package question006.simple.factory;

/**
 * @author poldi.chen
 * @className Test
 * @description TODO
 * @date 2019/5/28 18:38
 **/
public class Test {

    public static void main(String[] args) {
        Operation operationAdd = OperationFactory.createOperation("+");
        operationAdd.setValue1(10);
        operationAdd.setvalue2(5);
        System.out.println(operationAdd.getResult());
    }
}
