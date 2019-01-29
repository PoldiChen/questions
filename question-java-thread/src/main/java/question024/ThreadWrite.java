package question024;

import java.util.Random;

public class ThreadWrite implements Runnable {
	
	private DataObj dataObj;
	
	public ThreadWrite(DataObj dataObj) {
		this.dataObj = dataObj;
	}

	@Override
	public void run() {
		while (true) {
			dataObj.put(new Random().nextInt(100));
		}
	}

}
