package question006.abstractt.factory;

/**
 * @author poldi.chen
 * @className BenzBusinessCar
 * @description TODO
 * @date 2019/5/28 19:45
 **/
public class BenzBusinessCar implements BenzCar {

    @Override
    public void gasUp() {
        System.out.println("gas up for BenzBusinessCar");
    }
}
