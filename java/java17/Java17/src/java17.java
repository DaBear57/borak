
public class java17 {
	public static void format(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(i + "x" + j + "=" + arr[i][j] + "   ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		int[][] table = new int[9][9];
		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table[0].length; j++) {
				table[i][j] = i * j;
			}
		}
		format(table);
	}
}
