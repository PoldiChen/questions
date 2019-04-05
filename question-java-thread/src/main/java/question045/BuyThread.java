package question045;

/**
 * @author poldi.chen
 * @className BuyThread
 * @description TODO
 * @date 2019/4/5 13:39
 **/
public class BuyThread implements Runnable {

    public void run() {
        try {
            Thread.sleep((int) Math.random()*1000*20);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
