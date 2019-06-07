package question007;

/**
 * @author poldi.chen
 * @className Test
 * @description TODO
 * @date 2019/6/7 14:31
 **/
public class Test {

    public static void main(String[] args) {
        PersonDirector director = new PersonDirector();
        Person personChinese = director.constructPerson(new ChinesePersonBuilder());
        Person personForeign = director.constructPerson(new ForeignPersonBuilder());
        System.out.println(personChinese.getHair());
        System.out.println(personChinese.getName());
        System.out.println(personForeign.getHair());
        System.out.println(personForeign.getName());
    }
}
