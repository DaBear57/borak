
public class java12 {
	public static void main(String[] args) {
		method1();
	}
	
	public static void method1() {
		method2();
	}
	
	public static void method2() {
		method3();
	}
	
	public static void method3() {
		method4();
	}
	
	public static void method4() {
		System.out.println("Inception");
	}
}