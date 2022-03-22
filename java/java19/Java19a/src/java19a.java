
public class java19a {
	public static int[] lsd(int[] a, int bits) {
		int[] arr = a.clone();
		for (int i = 0; i < bits; i++) {
			int[] narr = new int[arr.length];
			int index = 0;
			for (int j = 0; j < arr.length; j++) {
				if ((arr[j] & (1 << i)) == 0) {
					narr[index] = arr[j];
					index++;
				}
			}
			for (int j = 0; j < arr.length; j++) {
				if ((arr[j] & (1 << i)) != 0) {
					narr[index] = arr[j];
					index++;
				}
			}
			arr = narr.clone();
		}
		return arr;
	}
	
	public static void main(String[] args) {
		int[] nums = new int[1000];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = (int) (Math.random() * 1001.0);
		}
		nums = lsd(nums,10);
		for (int num : nums) {
			System.out.println(num);
		}
	}
}
