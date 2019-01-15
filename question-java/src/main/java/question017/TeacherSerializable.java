package question017;

import java.io.Serializable;

public class TeacherSerializable implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int age;
	private String name;
	
	public TeacherSerializable(int age, String name) {
		this.age = age;
		this.name = name;
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
}
