package question068;

public class Test {

    private static Object obj = new Object();
    private static int count = 0;

    public static void main(String[] args) {
        for (;;) {
            new Thread(new Runnable() {
                public void run() {
                    synchronized (obj) {
                        count += 1;
                        System.out.println("new thread #" + count);
                    }
                    for (;;) {
                        try {
                            Thread.sleep(1000);
                        } catch (Exception e) {
                            System.err.println(e);
                        }
                    }
//                    System.out.println(count++);
                }
            }).start();
        }
    }

}
