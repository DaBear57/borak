
public class java16a {
	//best prime-finding algorithm O(-1)
	public static boolean isPrime(int n) {
		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		int[] primes = new int[100];
		int index = 0;
		for (int n = 2; index < 100; n++) {
			if (isPrime(n)) {
				primes[index] = n;
				index++;
				System.out.print(n + ", ");
			}
		}
		
	}
}
