package question010;

public class StudentDeepClone implements Cloneable {
	
	private int age;
	private String name;
	private Teacher teacher;
	
	public StudentDeepClone(int age, String name, Teacher teacher) {
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
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	public Object clone() throws CloneNotSupportedException {
		StudentDeepClone student = null;
		student = (StudentDeepClone) super.clone();
		student.teacher = (Teacher) teacher.clone(); // 引用的teacher对象也做复制，即深复制
		return student;
	}
	

}
