package question004;

import java.util.ArrayList;
import java.util.List;


public class OutOfMemoryErrorTest {

    public static void main(String[] args) {
        List<byte[]> list = new ArrayList<byte[]>();
        int i = 0;
        boolean flag = true;
        while (flag) {
            try {
                list.add(new byte[1024*1024]); // 每次增加1M的内容
                i ++;
            } catch (Throwable e) {
                flag = false;
                System.out.println(i);
                e.printStackTrace();
            }

        }
    }

}
