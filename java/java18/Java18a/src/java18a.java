import java.util.ArrayList;

public class java18a {
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
		ArrayList<Integer> primes = new ArrayList<Integer>();
		for (int n = 2; primes.size() < 100; n++) {
			if (isPrime(n)) {
				primes.add(n);
			}
		}
		System.out.println(primes);
	}
}
