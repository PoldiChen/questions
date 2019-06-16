package question004;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author poldi.chen
 * @className ThreadWithThreadLocal
 * @description TODO
 * @date 2019/6/16 15:01
 **/
public class ThreadWithThreadLocal implements Runnable {

    private static ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<SimpleDateFormat>(){
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }

    };

    private String timeStr;

    public ThreadWithThreadLocal(String timeStr) {
        this.timeStr = timeStr;
    }

    @Override
    public void run() {
        Date now = new Date();
        try {
            Date date = threadLocal.get().parse(this.timeStr);
            System.out.println(now.getTime() - date.getTime());
        } catch (ParseException e) {
            System.out.println("exception caught");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            service.submit(new ThreadWithThreadLocal("2019-06-16 15:29:00"));
        }
        service.shutdown();
    }
}
