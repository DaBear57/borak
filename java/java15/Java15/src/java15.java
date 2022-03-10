import java.util.Random;

public class java15 {
	public static void main(String[] args) {
		Random rng = new Random();
		int sum = 0;
		for (int i = 0; i < 1000; i++) {
			sum += rng.nextInt(1001) + 1000;
		}
		System.out.println((double) sum / 1000);
	}
}
