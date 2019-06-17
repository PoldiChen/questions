package question004;

public class SingletonVolatile {
	
	private static SingletonVolatile singleton;
	
	private SingletonVolatile() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static SingletonVolatile getInstance() {
		if (singleton == null) {
			synchronized (SingletonVolatile.class) {
				if (singleton == null) {
					singleton = new SingletonVolatile();
				}
			}
		}
		return singleton;
	}

}
