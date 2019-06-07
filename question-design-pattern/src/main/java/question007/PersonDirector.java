package question007;

/**
 * @author poldi.chen
 * @className PersonDirector
 * @description TODO
 * @date 2019/6/7 14:30
 **/
public class PersonDirector {

    public Person constructPerson(PersonBuilder personBuilder) {
        personBuilder.buildHair();
        personBuilder.buildName();
        return personBuilder.buildPerson();
    }
}
