package question003;

public class SingletonHungry {
	
	// 基于classloader机制避免了多线程的同步问题
	private static SingletonHungry instance = new SingletonHungry();
	
	private SingletonHungry() {}
	
	public static SingletonHungry getInstance() {
		return instance;
	}

}
