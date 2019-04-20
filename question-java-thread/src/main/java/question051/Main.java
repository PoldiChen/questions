package question051;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * @author poldi.chen
 * @className Main
 * @description TODO
 * @date 2019/4/20 12:35
 **/
public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println("main");
        FutureTask<String> futureTask = new FutureTask<String>(new MyFutureTask("poldi"));
        ExecutorService service = Executors.newFixedThreadPool(1);
        service.submit(futureTask);
        Thread.sleep(6000); // futureTask在同步执行，节省了等待时间
        System.out.println(futureTask.get());
        service.shutdown();
    }

}
