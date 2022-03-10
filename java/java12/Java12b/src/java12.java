import java.util.Scanner;

public class java12 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n1 = s.nextInt();
		int n2 = s.nextInt();
		System.out.println(product(n1,n2));
		s.close();
	}
	
	public static int product(int a, int b) {
		return a * b;
	}
}
