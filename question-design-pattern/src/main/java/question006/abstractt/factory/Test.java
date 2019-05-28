package question006.abstractt.factory;

/**
 * @author poldi.chen
 * @className Test
 * @description TODO
 * @date 2019/5/28 19:52
 **/
public class Test {

    public static void main(String[] args) {
        BenzCar car = new BusinessCarFactory().createBenzCar();
        car.gasUp();
    }
}
