package question072;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/**
 * @author poldi.chen
 * @className Main
 * @description TODO
 * @date 2019/4/21 13:17
 **/
public class Main {

    public static void main(String[] args) {
        // 有两个构造函数，可传入分隔符，或者传入分隔符、前缀、后缀
        StringJoiner stringJoiner = new StringJoiner(",");
        stringJoiner.add("chen");
        stringJoiner.add("wang");
        System.out.println(stringJoiner.toString());

        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        // Collection.collect内部的实现借助了StringJoiner
        System.out.println(list.stream().collect(Collectors.joining(",")));
    }
}
