package question034;

public class Test {
	
	public static void main(String[] args) {
		byte a = 127;
		byte b = 127;
		a = (byte) (a + b); // a��b������Ϊint���ͣ���ӵõ���Ҳ��int���ͣ�����ֱ�Ӹ���byte����
		a += b; // ��ʽ�Ľ����ת��Ϊa��byte����
		System.out.println(a); // -2��byte����1���ֽڣ�8λ���ܱ�ʾ���������λ2��7�η���1����127
	}

}
