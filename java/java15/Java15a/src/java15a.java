
public class java15a {
	public static void main(String[] args) {
		double sum = 0;
		for (int i = 0; i < 1000; i++) {
			sum += (int) (Math.random() * 1001) + 1000;
		}
		System.out.println(sum / 1000);
	}
}
