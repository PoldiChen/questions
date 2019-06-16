package question004;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author poldi.chen
 * @className ThreadNotSafe
 * @description TODO
 * @date 2019/6/16 15:16
 **/
public class ThreadNotSafe implements Runnable {

    private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private String timeStr;

    public ThreadNotSafe(String timeStr) {
        this.timeStr = timeStr;
    }

    @Override
    public void run() {
        Date now = new Date();
        try {
            Date client = SDF.parse(timeStr);
            System.out.println(now.getTime() - client.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            service.submit(new ThreadNotSafe("2019-06-16 15:23:00"));
        }
        service.shutdown();
    }
}
