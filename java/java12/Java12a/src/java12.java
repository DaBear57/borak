import java.util.Scanner;

public class java12 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n1 = s.nextInt();
		int n2 = s.nextInt();
		calc(n1,n2);
		s.close();
	}
	
	public static void calc (int a, int b)
	{
	   System.out.println(a + " + " + b + " = " + (a + b));
	   System.out.println(a + " - " + b + " = " + (a - b));
	   System.out.println(a + " * " + b + " = " + (a * b));
	   System.out.println(a + " / " + b + " = " + (a / b));
	   System.out.println(a + " % " + b + " = " + (a % b));
	}
}
