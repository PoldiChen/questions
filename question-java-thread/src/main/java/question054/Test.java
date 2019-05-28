package question054;

import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author poldi.chen
 * @className Test
 * @description TODO ???
 * @date 2019/5/28 16:23
 **/
public class Test {

    public static void main(String[] args) {
        MyTaskThread mtt = new MyTaskThread();
        Thread t = new Thread(mtt);
        Thread t1 = new Thread(mtt);
        t.start();
        t1.start();
    }
}

class MyService {

    public static void show(MyLock lock) {
        synchronized (lock) {
            System.out.println(lock.hashCode());
            while(true) {
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class MyLock {}

class MyTaskThread implements Runnable{
    MyService service = new MyService();
    @Override
    public void run() {
        service.show(new MyLock());
    }
//    ConcurrentSkipListMap
}


