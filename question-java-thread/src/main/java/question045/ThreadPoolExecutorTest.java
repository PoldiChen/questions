package question045;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author poldi.chen
 * @className ThreadPoolExecutorTest
 * @description TODO
 * @date 2019/4/5 13:32
 **/
public class ThreadPoolExecutorTest {

    public static void main(String[] args) {
//        System.out.println(Math.random()*1000*10);
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(new BuyThread());
    }

}
