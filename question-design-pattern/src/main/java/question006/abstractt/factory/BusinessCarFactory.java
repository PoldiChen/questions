package question006.abstractt.factory;

/**
 * @author poldi.chen
 * @className BusinessCarFactory
 * @description TODO
 * @date 2019/5/28 19:50
 **/
public class BusinessCarFactory implements ICarFactory {

    @Override
    public BenzCar createBenzCar() {
        return new BenzBusinessCar();
    }

    @Override
    public TeslaCar createTeslaCar() {
        return new TeslaBusinessCar();
    }
}
