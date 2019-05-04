package question037;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author poldi.chen
 * @className Test
 * @description TODO
 * @date 2019/5/4 13:11
 **/
public class Test {

    public static void main(String[] args) {
        ThreadSend threadSend = new ThreadSend(10001);
        ThreadReceive threadReceive = new ThreadReceive(10002);
        ExecutorService service = Executors.newFixedThreadPool(2);
        service.execute(threadSend);
        service.execute(threadReceive);
    }

}
