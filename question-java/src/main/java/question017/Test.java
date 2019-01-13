package question019;

import java.io.IOException;

public class Test {
	
	public static void main(String[] args) 
			throws CloneNotSupportedException, ClassNotFoundException, IOException {
		shadowClone(); // 浅复制
		deepClone(); // 深复制
		serializeClone(); // 序列化和反序列化实现深复制
	}
	
	private static void shadowClone() throws CloneNotSupportedException {
		System.out.println("--- shadow clone ---");
		Teacher teacher = new Teacher(40, "wang");
		StudentShadowClone student1 = new StudentShadowClone(15, "chen", teacher);
		StudentShadowClone student2 = (StudentShadowClone) student1.clone();
		student2.getTeacher().setAge(50);
		System.out.println(student2.getTeacher().getAge());
		System.out.println(student1.getTeacher().getAge());
	}
	
	private static void deepClone() throws CloneNotSupportedException {
		System.out.println("--- deep clone ---");
		Teacher teacher = new Teacher(40, "wang");
		StudentDeepClone student1 = new StudentDeepClone(20, "chen", teacher);
		StudentDeepClone student2 = (StudentDeepClone) student1.clone();
		student2.getTeacher().setAge(50);
		System.out.println(student2.getTeacher().getAge()); // 原对象的引用不变
		System.out.println(student1.getTeacher().getAge());
	}
	
	private static void serializeClone() throws ClassNotFoundException, IOException {
		System.out.println("--- serialize clone ---");
		TeacherSerializable teacher = new TeacherSerializable(40, "wang"); // 引用的对象也必须可序列化，即实现serializable接口
		StudentSerializable student1 = new StudentSerializable(15, "chen", teacher);
		StudentSerializable student2 = (StudentSerializable) student1.deepClone();
		student2.getTeacher().setAge(50);
		System.out.println(student2.getTeacher().getAge());
		System.out.println(student1.getTeacher().getAge());
	}

}
