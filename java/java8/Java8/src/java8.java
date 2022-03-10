import java.util.Scanner;
public class java8 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("Enter an int: ");
		int i = s.nextInt();
		System.out.print("Enter a string: ");
		String dummystupid = s.nextLine();
		String str = s.nextLine();
		int n = 0;
		while (n < i) {
			n++;
			System.out.println(str + " " + n);
		}
		s.close();
	}
}
