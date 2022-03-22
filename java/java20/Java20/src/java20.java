
public class java20 {
	public static void fib(int a, int b, int i) {
		if (i == 0) {
			return;
		}
		System.out.println(a+b);
		fib(a+b,a,i-1);
	}
	
	public static void main(String[] args) {
		fib(0,1,20);
	}
}
