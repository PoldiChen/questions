package question019;

public class StudentShadowClone implements Cloneable {
	
	private int age;
	private String name;
	private Teacher teacher;
	
	public StudentShadowClone(int age, String name, Teacher teacher) {
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
		StudentShadowClone student = (StudentShadowClone)super.clone(); // 只复制对象本身，浅复制
		return student;
	}
	
	

}
