package question004;

public class SingletonEnum {
	
	private SingletonEnum() {}
	
	public static SingletonEnum getInstance() {
		return MyEnum.INSTANCE.getInstance();
	}
	
	private static enum MyEnum {
		
		INSTANCE;
		
		private SingletonEnum instance;
		
		private MyEnum() {
			instance = new SingletonEnum();
		}
		
		public SingletonEnum getInstance() {
			return instance;
		}
	}

}
