package question023;

import java.lang.ref.PhantomReference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class Test {
	
	public static void main(String[] args) {
//		soft();
//		weak();
		phantom();
	}
	
	public static void soft() {
		Object obj = new Object();
		SoftReference<Object> softReference = new SoftReference<Object>(obj);
		obj = null;
		Object obj1 = softReference.get();
		System.out.println(obj1);
	}
	
	public static void weak() {
		Object obj = new Object();
		WeakReference<Object> weakReference = new WeakReference<Object>(obj);
		obj = null;
		Object obj1 = weakReference.get();
		System.out.println(obj1);
	}
	
	public static void phantom() {
		Object obj = new Object();
		PhantomReference<Object> phantomReference = new PhantomReference<Object>(obj, null);
		obj = null;
		Object obj1 = phantomReference.get();
		System.out.println(obj1);
		System.out.println(phantomReference.isEnqueued());
	}

}
