package question019;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class StudentSerializable implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int age;
	private String name;
	private TeacherSerializable teacher; // 引用的对象也必须可序列化，即实现serializable接口
	
	public StudentSerializable(int age, String name, TeacherSerializable teacher) {
		this.age = age;
		this.name = name;
		this.teacher = teacher;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public TeacherSerializable getTeacher() {
		return teacher;
	}
	public void setTeacher(TeacherSerializable teacher) {
		this.teacher = teacher;
	}
	
	public Object deepClone() throws IOException, ClassNotFoundException {
		ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream();
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteOutputStream);
		objectOutputStream.writeObject(this); // 将对象写入流
		ByteArrayInputStream byteInputStream = 
				new ByteArrayInputStream(byteOutputStream.toByteArray());
		ObjectInputStream objectInputStream = new ObjectInputStream(byteInputStream);
		Object object = objectInputStream.readObject(); // 从流中读出对象
		return object;
	}
	
}
