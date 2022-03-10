import java.util.Scanner;
public class java7 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("What is your age? ");
		int age = s.nextInt();
		System.out.print("What is your favorite number? ");
		int num = s.nextInt();
		System.out.print("What year do you graduate? ");
		int year = s.nextInt();
		
		if (age < 18) System.out.println("you are young");
		if (num < 100) {
			System.out.println("cool number");
		} else {
			System.out.println("way cool number");
		}
		if (year == 2025) {
			System.out.println("freshman");
		} else if (year == 2024) {
			System.out.println("sophomore");
		} else if (year == 2023) {
			System.out.println("junior");
		} else {
			System.out.println("senior");
		}
		
		s.close();
	}
}
