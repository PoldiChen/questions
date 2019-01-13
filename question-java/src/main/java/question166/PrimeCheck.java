package question209;

public class PrimeCheck {
	
	public static void main(String[] args) {
		System.out.println(isPrime(6));
	}
	
	public static boolean isPrime(int n) {
		boolean flag = true;
		if (n == 1) {
			flag = false;
		} else {
			for (int i=2; i<=Math.sqrt(n); i++) { // sqrt����ƽ��
				if (n%i == 0) {
					flag = false;
					break;
				} else {
					flag = true;
				}
			}
		}
		return flag;
	}

}
