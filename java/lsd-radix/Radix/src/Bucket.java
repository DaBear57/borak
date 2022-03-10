
public class Bucket {
	int[] contents;
	Bucket[] children;
	
	public Bucket(int[] c, int depth) {
		contents = c;
		if (depth == 0) return;
	}
}
