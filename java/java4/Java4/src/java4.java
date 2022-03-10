import java.util.*;

public class java4 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("Enter your age: ");
		int age = s.nextInt();
		System.out.print("Enter your name: ");
		String dumb = s.nextLine();
		String name = s.nextLine();
		System.out.println(name + " is not " + age + " years old");
		s.close();
	}
}
