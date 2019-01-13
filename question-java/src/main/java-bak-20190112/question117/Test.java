package question117;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
	
	public static void main(String[] args) {
		final DataObj dataObj = new DataObj();
		ExecutorService service = Executors.newCachedThreadPool();
		service.execute(new ThreadRead(dataObj));
		service.execute(new ThreadRead(dataObj));
		service.execute(new ThreadRead(dataObj));
		service.execute(new ThreadWrite(dataObj));
		service.execute(new ThreadWrite(dataObj));
		service.execute(new ThreadWrite(dataObj));
		service.shutdown();
	}

}
