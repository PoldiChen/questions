package question142;

public class FatherChild {
	
	public static void main(String[] args) {
		Child child = new Child();
		child.test();
		// ���ྲ̬�����
		// ���ྲ̬�����
		// ���๹�캯��
		// ���๹�캯��
		// ������ͨ����test
	}
}

class Father {
	
	static {
		System.out.println("static of Father");
	}
	
	public Father() {
		System.out.println("constructor of Father");
	}
}

class Child extends Father {
	
	static {
		System.out.println("static of Child");
	}
	
	public Child() {
		System.out.println("constructor of Child");
	}
	
	public void test() {
		System.out.println("test");
	}
	
}
