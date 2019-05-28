package question006.abstractt.factory;

/**
 * @author poldi.chen
 * @className TeslaSportCar
 * @description TODO
 * @date 2019/5/28 19:46
 **/
public class TeslaSportCar implements TeslaCar {

    @Override
    public void charge() {
        System.out.println("charge for TeslaSportCar");
    }
}
