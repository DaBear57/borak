import java.util.Scanner;

public class java16 {
	public static boolean isPrime(int n) {
		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("Input number: ");
		int number = s.nextInt();
		System.out.println(isPrime(number));
		s.close();
	}
}
