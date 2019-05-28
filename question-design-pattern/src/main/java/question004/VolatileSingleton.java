package question004;

public class VolatileSingleton {
	
	private static VolatileSingleton singleton;
	
	private VolatileSingleton() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static VolatileSingleton getInstance() {
		if (singleton == null) {
			synchronized (VolatileSingleton.class) {
				if (singleton == null) {
					singleton = new VolatileSingleton();
				}
			}
		}
		return singleton;
	}

}
