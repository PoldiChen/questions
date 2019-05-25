package question034;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @author poldi.chen
 * @className Test
 * @description TODO
 * @date 2019/5/25 13:36
 **/
public class Test {

    public static void main(String[] args) {
        Set<Person> persons = new HashSet<>();
        persons.add(new Person("tom", 20));
        persons.add(new Person("jack", 21));
        persons.add(new Person("thoe", 24));
        // 传统写法
        persons.stream().filter(new Predicate<Person>() {
            @Override
            public boolean test(Person person) {
                if (person.getAge() > 20) {
                    return true;
                } else {
                    return false;
                }
            }
        }).forEach(new Consumer<Person>() {
            @Override
            public void accept(Person person) {
                System.out.println(person.getName());
            }
        });
        // lambda写法
        persons.stream().filter(person -> person.getAge() > 20).forEach(person -> {
            System.out.println(person.getName());
        });

    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
