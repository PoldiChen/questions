package question051;

import jdk.nashorn.internal.codegen.CompilerConstants;

import java.util.concurrent.Callable;

/**
 * @author poldi.chen
 * @className MyFutureTask
 * @description TODO
 * @date 2019/4/20 12:32
 **/
public class MyFutureTask implements Callable<String> {

    protected String resultData;

    public MyFutureTask(String resultData) {
        this.resultData = resultData;
    }

    @Override
    public String call() throws Exception {
        System.out.println("MyFutureTask@call");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return resultData + "...";
    }

}
