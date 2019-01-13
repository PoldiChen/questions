package question183;

public class SingletonStaticInnerClass {
	
	private static class Holder {
		private static SingletonStaticInnerClass instance = new SingletonStaticInnerClass();
	}
	
	private SingletonStaticInnerClass() {}
	
	public static SingletonStaticInnerClass getInstance() {
		return Holder.instance;
	}

}
