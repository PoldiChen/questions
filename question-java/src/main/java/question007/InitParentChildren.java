package question007;

public class InitParentChildren {
	
	public static void main(String[] args) {
		Child child = new Child();
	}

}

class Parent {
	static {
		System.out.println("static of Parent");
	}
	public Parent() {
		System.out.println("constructor of Parent");
	}
}

class Child extends Parent {
	static {
		System.out.println("static of Child");
	}
	public Child() {
		System.out.println("constructor of Child");
	}
}
