package question018;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyInvocationHandler implements InvocationHandler {
	
	Object object; // 目标类的实例

	@Override
	public Object invoke(Object object, Method method, Object[] objects) 
			throws Throwable {
		return method.invoke(this.object, objects);
	}
	
	public Object bind(Object object) {
		this.object = object; // 绑定目标类实例
		return Proxy.newProxyInstance( // 返回一个代理接口对象
				object.getClass().getClassLoader(), 
				object.getClass().getInterfaces(), 
				this
				);
	}

}
