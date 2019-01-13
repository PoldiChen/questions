package question019;

import java.io.IOException;

public class Test {
	
	public static void main(String[] args) 
			throws CloneNotSupportedException, ClassNotFoundException, IOException {
		shadowClone(); // ǳ����
		deepClone(); // ���
		serializeClone(); // ���л��ͷ����л�ʵ�����
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
		System.out.println(student2.getTeacher().getAge()); // ԭ��������ò���
		System.out.println(student1.getTeacher().getAge());
	}
	
	private static void serializeClone() throws ClassNotFoundException, IOException {
		System.out.println("--- serialize clone ---");
		TeacherSerializable teacher = new TeacherSerializable(40, "wang"); // ���õĶ���Ҳ��������л�����ʵ��serializable�ӿ�
		StudentSerializable student1 = new StudentSerializable(15, "chen", teacher);
		StudentSerializable student2 = (StudentSerializable) student1.deepClone();
		student2.getTeacher().setAge(50);
		System.out.println(student2.getTeacher().getAge());
		System.out.println(student1.getTeacher().getAge());
	}

}
