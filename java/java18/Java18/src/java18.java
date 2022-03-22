import java.util.ArrayList;

public class java18 {
	public static void main(String[] args) {
		ArrayList<Character> list = new ArrayList<Character>();
		list.add('b');
		list.add(0, 'c');
		list.set(1, 'd');
		System.out.println("" + list.get(0) + list.size() + list.indexOf('d'));
		list.remove(0);
		list.remove((Character) 'd');
		System.out.println("" + list.isEmpty() + list.contains('b'));
	}
}
