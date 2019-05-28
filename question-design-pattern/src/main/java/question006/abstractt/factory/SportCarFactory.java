package question006.abstractt.factory;

/**
 * @author poldi.chen
 * @className SportCarFactory
 * @description TODO
 * @date 2019/5/28 19:49
 **/
public class SportCarFactory implements ICarFactory {

    @Override
    public BenzCar createBenzCar() {
        return new BenzSportCar();
    }

    @Override
    public TeslaCar createTeslaCar() {
        return new TeslaSportCar();
    }
}
