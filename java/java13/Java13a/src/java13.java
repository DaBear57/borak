public class java13 {
	public static void main(String[] args) {
		double pi = 0.0;
		int i;
		for (i = 0; Math.abs(pi * 4.0 - Math.PI) >= 0.00001; i++) {
			pi += (i % 2 * -2.0 + 1.0) / (i * 2.0 + 1.0);
		}
		System.out.println(i);
	}
}