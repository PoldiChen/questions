package question019;

import java.util.Random;

public class Philosopher implements Runnable {
	
	private Chopsticks chopsticksLeft;
	private Chopsticks chopsticksRight;
	private int index;
	
	public Philosopher(Chopsticks left, Chopsticks right, int index) {
		this.chopsticksLeft = left;
		this.chopsticksRight = right;
		this.index = index;
	}

	public void run() {
		try {
			while (true) {
				thinking();
				chopsticksLeft.take();
				chopsticksRight.take();
				eating();
				chopsticksLeft.drop();
				chopsticksRight.drop();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void thinking() {
		System.out.println(toString()+"thinking");
		try {
			Thread.sleep(getMillis());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void eating() {
		System.out.println(toString()+"eating");
		try {
			Thread.sleep(getMillis());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private int getMillis() {
		Random random = new Random();
		return random.nextInt(5000);
	}
	
	@Override
	public String toString() {
		return "philosopher["+index+"]";
	}

}
