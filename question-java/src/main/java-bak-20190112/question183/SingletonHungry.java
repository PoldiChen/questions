package question183;

public class SingletonHungry {
	
	// ����classloader���Ʊ����˶��̵߳�ͬ������
	private static SingletonHungry instance = new SingletonHungry();
	
	private SingletonHungry() {}
	
	public static SingletonHungry getInstance() {
		return instance;
	}

}
