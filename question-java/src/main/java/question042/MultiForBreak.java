package question049;

public class MultiForBreak {
	
	public static void main(String[] args) { // ��������Ƕ��ѭ��
		ok: // ����ı�ʶ
			for (int i=0; i<10; i++) {
				for (int j=0; j<10; j++) {
					System.out.println(i + "," + j);
					if (j == 5) {
						break ok; // ��������Ƕ��ѭ��
					}
				}
			}
	}

}
