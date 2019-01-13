package question018;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyInvocationHandler implements InvocationHandler {
	
	Object object; // Ŀ�����ʵ��

	@Override
	public Object invoke(Object object, Method method, Object[] objects) 
			throws Throwable {
		return method.invoke(this.object, objects);
	}
	
	public Object bind(Object object) {
		this.object = object; // ��Ŀ����ʵ��
		return Proxy.newProxyInstance( // ����һ������ӿڶ���
				object.getClass().getClassLoader(), 
				object.getClass().getInterfaces(), 
				this
				);
	}

}
