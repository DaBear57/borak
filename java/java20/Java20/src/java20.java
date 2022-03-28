
public class java20 {
	public static int fib(int a) {
		if (a == 0 || a == 1) {
			return 1;
		}
		return fib(a-1) + fib(a-2);
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 20; i++) {
			System.out.println(fib(i));
		}
	}
}
