package question033;

public class OverrideStatic {
	//

}

class Parent {
	
	public static void test() {}
}

class Child extends Parent {
	
//	@Override // ���ܸ��Ǹ����static����
	public static void test() {}
}