import java.util.ArrayList;

public class java19b {
	public static ArrayList<Integer> lsd(ArrayList<Integer> a, int bits) {
		ArrayList<Integer> arr = new ArrayList<Integer>(a);
		for (int i = 0; i < bits; i++) {
			ArrayList<Integer> narr = new ArrayList<Integer>();
			for (int j = 0; j < arr.size(); j++) {
				if ((arr.get(j) & (1 << i)) == 0) {
					narr.add(arr.get(j));
				}
			}
			for (int j = 0; j < arr.size(); j++) {
				if ((arr.get(j) & (1 << i)) != 0) {
					narr.add(arr.get(j));
				}
			}
			arr = new ArrayList<Integer>(narr);
		}
		return arr;
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for (int i = 0; i < 1000; i++) {
			nums.add((int) (Math.random() * 1001.0));
		}
		nums = lsd(nums,10);
		for (int num : nums) {
			System.out.println(num);
		}
	}
}
