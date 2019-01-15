package question016.aop;

public class SuperMan implements Man {

	@Override
	public void info() {
		System.out.println("i am a superman");
	}

	@Override
	public void fly() {
		System.out.println("i can fly");
	}

}
