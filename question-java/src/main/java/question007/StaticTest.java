package question007;

import java.util.HashMap;

/**
 * @author poldi.chen
 * @className StaticTest
 * @description TODO
 * @date 2019/5/11 15:55
 **/
public class StaticTest
{
    public static void main(String[] args)
    {
        staticFunction();
    }

//    2
//    3
//    a=110,b=0
//    1
//    4

    static StaticTest st = new StaticTest();

    static
    {
        System.out.println("1");
    }

    {
        System.out.println("2");
    }

    StaticTest()
    {
        System.out.println("3");
        System.out.println("a="+a+",b="+b);
    }

    public static void staticFunction(){
        System.out.println("4");
    }

    int a=110;
    static int b =112;
}
