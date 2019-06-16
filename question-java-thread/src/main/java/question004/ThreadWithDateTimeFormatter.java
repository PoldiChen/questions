package question004;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author poldi.chen
 * @className ThreadWithDateTimeFormatter
 * @description TODO
 * @date 2019/6/16 15:30
 **/
public class ThreadWithDateTimeFormatter implements Runnable {

    private static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private String timeStr;

    public ThreadWithDateTimeFormatter(String timeStr) {
        this.timeStr = timeStr;
    }

    @Override
    public void run() {
        Date now = new Date();
        LocalDateTime localDateTime = (LocalDateTime) DTF.parse(this.timeStr);
        System.out.println(localDateTime.getSecond());
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            service.submit(new ThreadWithDateTimeFormatter("2019-06-16 15:40:00"));
        }
        service.awaitTermination(1, TimeUnit.SECONDS);
        service.shutdown();
    }
}
