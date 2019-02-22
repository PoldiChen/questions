package question055;

public class Decompose {
	
	public static void main(String[] args) {
		decompose(3000);
	}
	
	public static void decompose(int n) {
		while (n > 1) {
			for (int i=2; i<=n; i++) {
				if (n%i == 0) {
					System.out.println(i);
					n = n/i;
					break;
				}
			}
		}
		
	}

}
