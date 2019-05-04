package question037;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author poldi.chen
 * @className Test2
 * @description TODO
 * @date 2019/5/4 13:17
 **/
public class Test2 {

    public static void main(String[] args) {
        ThreadSend threadSend = new ThreadSend(10002);
        ThreadReceive threadReceive = new ThreadReceive(10001);
        ExecutorService service = Executors.newFixedThreadPool(2);
        service.execute(threadSend);
        service.execute(threadReceive);
    }
}
