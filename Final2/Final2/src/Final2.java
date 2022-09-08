//Ben DeBear
import java.util.ArrayList;
import java.util.Scanner;

public class Final2 {
	public static void methodPrint() {
		System.out.println("***\nFinal Exam\n***");
	}
	
	public static int methodRecur(int n) {
		if (n == 0) return -3;
		return 4 * methodRecur(n-1) + 2;
	}
	
	public static void main(String[] args) {
		//part 1
		Scanner s = new Scanner(System.in);
		
		int[] intarr = new int[4];
		ArrayList<String> strlist = new ArrayList<String>();
		
		for (int i = 0; i < 4; i++) {
			System.out.print("Enter integer: ");
			intarr[i] = s.nextInt();
			String dummy = s.nextLine();
			
			System.out.print("Enter String: ");
			strlist.add(s.nextLine());
		}
		
		for (int i = 0; i < intarr.length; i++) {
			System.out.println("" + intarr[i] + "\t" + strlist.get(i));
		}
		
		//part 2
		methodPrint();
		
		//part 3
		System.out.print("Enter integer for recursive function: ");
		int num = s.nextInt();
		String dummy = s.nextLine();
		System.out.println(methodRecur(num));
		
		s.close();
	}
}
