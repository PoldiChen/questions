package question074;

public class NewInstance {
	
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		Class class1 = A.class; // class1是A类的类类型
		A a = (A) class1.newInstance();
		System.out.println(a);
		
		Class class2 = Class.forName("question074.A"); // class2也是A累的类类型
		a = (A) class2.newInstance();
		System.out.println(a);

	}

}

class A {}
