package question007;

/**
 * @author poldi.chen
 * @className ForeignPersonBuilder
 * @description TODO
 * @date 2019/6/7 14:28
 **/
public class ForeignPersonBuilder implements PersonBuilder {

    private Person person;

    public ForeignPersonBuilder() {
        this.person = new Person();
    }

    @Override
    public void buildHair() {
        person.setHair("yellow hair");
    }

    @Override
    public void buildName() {
        person.setName("english name");
    }

    @Override
    public Person buildPerson() {
        return person;
    }
}
