package question004;

public class SingletonHungryStatic {
	
	private static SingletonHungryStatic instance = null;
	
	static { // 和普通的饿汉式没什么区别
		instance = new SingletonHungryStatic();
	}
	
	private SingletonHungryStatic() {}
	
	public static SingletonHungryStatic getInstance() {
		return instance;
	}

}
