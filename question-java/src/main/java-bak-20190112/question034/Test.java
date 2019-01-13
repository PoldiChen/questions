package question034;

public class Test {
	
	public static void main(String[] args) {
		byte a = 127;
		byte b = 127;
		a = (byte) (a + b); // a和b被提升为int类型，相加得到的也是int类型，不能直接赋给byte类型
		a += b; // 隐式的将结果转化为a的byte类型
		System.out.println(a); // -2，byte类型1个字节，8位，能表示的最大整数位2的7次方减1，即127
	}

}
