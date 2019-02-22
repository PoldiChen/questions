package question009;

public class Main {
	
	public static void main(String[] args) {
		RealTarget target = new RealTarget();
		MyInvocationHandler invocationHandler = new MyInvocationHandler();
		ProxyInter proxy = (ProxyInter) invocationHandler.bind(target);
		proxy.action();
	}

}
