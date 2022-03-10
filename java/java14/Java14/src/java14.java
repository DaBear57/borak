import java.util.Scanner;

class java14 {
	public static int getGP(String grade) {
		if (grade.equals("A")) {
			return 4;
		} else if (grade.equals("B")) {
			return 3;
		} else if (grade.equals("C")) {
			return 2;
		} else if (grade.equals("D")) {
			return 1;
		} else {
			return 0;
		}
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("Number of classes: ");
		int n = s.nextInt();
		int sum = 0;
		int credits = 0;
		for (int i = 1; i <= n; i++) {
			System.out.println("Course " + i);
			System.out.print("How many credits? ");
			int credit = s.nextInt();
			System.out.print("Grade Received: ");
			String d = s.nextLine();
			int grade = getGP(s.nextLine());
			sum += credit * grade;
			credits += credit;
		}
		double GPA = (double) sum / credits;
		System.out.println("Your GPA is: " + GPA);
		//14 ends here
		if (GPA > 3.0 && GPA <= 4.0) {
			System.out.println("That's fine");
		} else if (GPA > 2.0 && GPA <= 3.0) {
			System.out.println("You committed a cardinal sin");
		} else if (GPA > 1.0 && GPA <= 2.0) {
			System.out.println("Real bad");
		} else {
			System.out.println("I'm having a seizure");
		}
		s.close();
    }
}