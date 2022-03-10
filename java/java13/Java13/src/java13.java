
public class java13 {
	public static void main(String[] args) {
		double pi = 0.0;
		for (int i = 0; i < 10000; i++) {
			pi += (i % 2 * -2.0 + 1.0) / (i * 2.0 + 1.0);
		}
		System.out.println(pi * 4.0);
	}
}
