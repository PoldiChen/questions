package question074;

import java.util.ArrayList;
import java.util.List;

class AA {}

class BB {
    int a = 1;
}

class CC {
    long a = 1L;
}

class DD {
    String str = "hello";
}

public class Test {

    public static void main(String[] args) {
        AA aa = new AA(); // 16
        BB bb = new BB(); // 20
        CC cc = new CC(); // 20
        DD dd = new DD(); // 24
        System.out.println("done");
    }

}
