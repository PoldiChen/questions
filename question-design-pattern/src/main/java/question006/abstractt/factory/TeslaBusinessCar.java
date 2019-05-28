package question006.abstractt.factory;

/**
 * @author poldi.chen
 * @className TeslaBusinessCar
 * @description TODO
 * @date 2019/5/28 19:47
 **/
public class TeslaBusinessCar implements TeslaCar {

    @Override
    public void charge() {
        System.out.println("charge for TeslaBusinessCar");
    }
}
