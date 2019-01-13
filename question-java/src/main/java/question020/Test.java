package question022;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;

public class Test implements Cloneable, Serializable {
	
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) throws Exception {
		System.out.println("new");
		_new();
		System.out.println("Class newInstance()");
		_newInstance();
		System.out.println("Constructor newInstance()");
		_constructor();
		System.out.println("clone()");
		_clone();
		System.out.println("serialize");
		_serialize();
	}
	
	// new关键字
	public static void _new() {
		Test test = new Test();
		System.out.println(test);
	}
	
	// Class类的newInstance()方法
	public static void _newInstance() throws Exception {
		Test test1 = (Test) Class.forName("question022.Test").newInstance();
		Test test2 = Test.class.newInstance();
		System.out.println(test1);
		System.out.println(test2);

	}
	
	// Constructor类的newInstance()方法
	public static void _constructor() throws Exception {
		Constructor<Test> constructor = Test.class.getConstructor();
		Test test = constructor.newInstance();
		System.out.println(test);
	}
	
	// clone()方法
	public static void _clone() throws CloneNotSupportedException {
		Test test = new Test();
		Test newObj = (Test) test.clone();
		System.out.println(test);
		System.out.println(newObj);
	}
	
	// 序列化和反序列化
	public static void _serialize() throws Exception {
		Test test = new Test();
		System.out.println(test);
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("e:\\test.txt"));
		out.writeObject(test);
		out.close();
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("e:\\test.txt"));
		Test test2 = (Test) in.readObject();
		System.out.println(test2);
		in.close();
	}

}
