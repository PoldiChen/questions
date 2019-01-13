package question018.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {
	
	private Object object;
	
	public void setObject(Object object) {
		this.object = object;
	}

	@Override
	public Object invoke(Object arg0, Method method, Object[] objects) throws Throwable {
		ManUtil manUtil = new ManUtil();
		manUtil.method1(); // ��̬��ӵķ���
		Object proxyObject = method.invoke(this.object, objects); // Ŀ����ķ���
		manUtil.method2(); // ��̬��ӵķ���
		return proxyObject;
	}

}
