package question016.aop;

import java.lang.reflect.Proxy;

public class MyProxy {
	
	public static Object getProxyObject(Object object) {
		MyInvocationHandler myInvocationHandler = new MyInvocationHandler();
		myInvocationHandler.setObject(object);
		return Proxy.newProxyInstance(
				object.getClass().getClassLoader(), 
				object.getClass().getInterfaces(), 
				myInvocationHandler
				);
	}

}
