package question024;

public class ThreadRead implements Runnable {
	
	private DataObj dataObj;
	
	public ThreadRead(DataObj dataObj) {
		this.dataObj = dataObj;
	}

	@Override
	public void run() {
		while (true) {
			dataObj.get();
		}
	}

}
