import java.util.Scanner;

public class java11 {
	public static void main(String[] args) {
		for (double i = 0.0; i < 10.0; i++) {
			System.out.println(i * (i + 1) * 0.5);
		}
		
		int j = 0;
		Scanner s = new Scanner(System.in);
		while (j < 10) {
			j = s.nextInt();
			System.out.println(j);
		}
		
		int k = 0;
		while (true) {
			k++;
			System.out.println(k);
			if (k > 10) {
				break;
			}
		}
		
		s.close();
	}
}
