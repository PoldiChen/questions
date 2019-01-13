package question033;

public class OverrideStatic {
	//

}

class Parent {
	
	public static void test() {}
}

class Child extends Parent {
	
//	@Override // 不能覆盖父类的static方法
	public static void test() {}
}