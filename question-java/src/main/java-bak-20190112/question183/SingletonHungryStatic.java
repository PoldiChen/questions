package question183;

public class SingletonHungryStatic {
	
	private static SingletonHungryStatic instance = null;
	
	static { // ����ͨ�Ķ���ʽûʲô����
		instance = new SingletonHungryStatic();
	}
	
	private SingletonHungryStatic() {}
	
	public static SingletonHungryStatic getInstance() {
		return instance;
	}

}
