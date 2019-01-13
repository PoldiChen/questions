package question175;

public class MyThread implements Runnable {
	
	private Resource resource;
	
	public MyThread(Resource resource) {
		this.resource = resource;
	}

	@Override
	public void run() {
		resource.setResource("111", "222");
	}

}
