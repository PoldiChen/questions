package question006.abstractt.factory;

/**
 * @author poldi.chen
 * @className BenzSportCar
 * @description TODO
 * @date 2019/5/28 19:44
 **/
public class BenzSportCar implements BenzCar {

    @Override
    public void gasUp() {
        System.out.println("gas up for BenzSportCar");
    }
}
