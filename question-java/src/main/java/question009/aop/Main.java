package question009.aop;

public class Main {
	
	public static void main(String[] args) {
		SuperMan superMan = new SuperMan();
		Man man = (Man) MyProxy.getProxyObject(superMan);
		man.info();
		man.fly();
	}

}
