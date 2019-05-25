package question063;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @author poldi.chen
 * @className LambdaTest
 * @description TODO
 * @date 2019/5/25 13:55
 **/
public class LambdaTest {

    public static void main(String[] args) {
//        lambdaThread();
//        lambdaFilter();
        lambdaSort();
    }

    private static void lambdaThread() {
        // 传统写法
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("this is thread 1");
            }
        });
        thread1.start();
        // Lambda写法
        Thread thread2 = new Thread(() -> System.out.println("this is thread 2"));
        thread2.start();
    }

    private static void lambdaFilter() {
        Set<String> sets = new HashSet<>();
        sets.add("hello");
        sets.add("world");
        // 传统写法
        sets.stream().filter(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                if (s.equals("hello")) {
                    return true;
                } else {
                    return false;
                }
            }
        }).forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
        // lambda写法
        sets.stream().filter(s -> s.equals("hello")).forEach(s -> {
            System.out.println(s);
        });
    }

    private static void lambdaSort() {
        List<Person> list = new ArrayList<>();
        list.add(new Person(21, "tom-21"));
        list.add(new Person(20, "jack-20"));
        list.add(new Person(22, "thoe-22"));
        // 传统写法
        Collections.sort(list, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o2.getAge() - o1.getAge();
            }
        });
        System.out.println(list.toString());
        // lambda写法
        Collections.sort(list, (person1, person2) -> person1.getAge() - person2.getAge());
        System.out.println(list.toString());
    }

}

class Person {
    private int age;
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
