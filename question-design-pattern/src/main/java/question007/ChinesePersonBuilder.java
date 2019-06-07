package question007;

/**
 * @author poldi.chen
 * @className ChinesePersonBuilder
 * @description TODO
 * @date 2019/6/7 14:22
 **/
public class ChinesePersonBuilder implements PersonBuilder {

    private Person person;

    public ChinesePersonBuilder() {
        this.person = new Person();
    }

    @Override
    public void buildHair() {
        person.setHair("black hair");
    }

    @Override
    public void buildName() {
        person.setName("chinese name");
    }

    @Override
    public Person buildPerson() {
        return person;
    }
}
