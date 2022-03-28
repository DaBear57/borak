import java.util.ArrayList;
import processing.core.*;

public class test extends PApplet {
	static int terms = 500;
	static int[] nums = new int[terms];
	static int[] inums = new int[terms];
	static int[] qnums = new int[terms];
	static ArrayList<Integer> qstarts = new ArrayList<Integer>();
	static ArrayList<Integer> qends = new ArrayList<Integer>();
	static ArrayList<Integer> qless = new ArrayList<Integer>();
	static ArrayList<Integer> qmore = new ArrayList<Integer>();
	static int index = 0;
	static int index2 = 0;
	static int index3 = 0;
	static int pivot = 0;
	static int speed = 100;
	static int progress = 0;
	static boolean fixed = false;

	public void shuffle() {
		ArrayList<Integer> start = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			start.add(i);
		}
		for (int i = 0; i < nums.length; i++) {
			int j = floor(random(start.size()));
			nums[i] = start.get(j);
			start.remove(j);
		}
	}
	
    public void setup(){
    	noStroke();
    	frameRate(60);
        shuffle();
        
    }
    
    public boolean bubble() {
    	if (nums[index] > nums[index + 1]) {
    		int temp = nums[index];
    		nums[index] = nums[index + 1];
    		nums[index + 1] = temp;
    	}
    	if (index == nums.length - progress - 2) progress++;
        index = (index + 1) % (nums.length - progress);
        return progress == nums.length - 1;
    }
    
    public boolean insertion() {
    	if (index2 == 0) {
    		inums = nums.clone();
    		index++;
    	}
    	for (int i = 0; i < index2; i++) {
    		nums[i] = inums[i];
    	}
    	nums[index2] = inums[index];
    	for (int i = index2 + 1; i <= index; i++) {
    		nums[i] = inums[i-1];
    	}
    	for (int i = index + 1; i < nums.length; i++) {
    		nums[i] = inums[i];
    	}
    	if (nums[index2] < nums[index2+1] || index2 == index) {
    		index2 = 0;
    		progress++;
    	} else {
    		index2++;
    	}
    	return progress == nums.length - 1;
    }
    
    public boolean quick() {
    	if (!fixed) {
    		qstarts.add(0);
            qends.add(nums.length - 1);
    		index = -1;
    		fixed = true;
    	}
    	
    	//on divide completion
    	if (index == -1) {
    		qnums = nums.clone();
    		if (qstarts.size() == 0) {
    			return true;
    		} else {
    			pivot = qnums[qstarts.get(0)];
    		}
    		index = qstarts.get(0) + 1;
    		qless.clear();
    		qmore.clear();
    	}
    	
    	//sorting
    	if (qnums[index] < pivot) {
    		qless.add(qnums[index]);
    	} else {
    		qmore.add(qnums[index]);
    	}
    	index++;
    	
    	//update array
    	int i;
    	for (i = 0; i < qless.size(); i++) {
    		nums[i + qstarts.get(0)] = qless.get(i);
    	}
    	nums[i + qstarts.get(0)] = pivot;
    	for (i = 0; i < qmore.size(); i++) {
    		nums[i + qstarts.get(0) + qless.size() + 1] = qmore.get(i);
    	}
    	
    	//on finished with sort
    	if (index == qends.get(0) + 1) {
    		index = -1;
    		if (qmore.size() > 1) {
	    		qstarts.add(1, qstarts.get(0) + qless.size() + 1);
	    		qends.add(1, qends.get(0));
    		}
    		if (qless.size() > 1) {
	    		qstarts.add(1, qstarts.get(0));
	    		qends.add(1, qstarts.get(0) + qless.size() - 1);
    		}
    		qstarts.remove(0);
    		qends.remove(0);
    	}
    	
    	return false;
    }
    
    public boolean radix(int bits) {
    	if (!fixed) {
    		qnums = nums.clone();
    		for (int i : nums) {
				qmore.add(i);
			}
    		fixed = true;
    	}
    	
		if (index2 == bits) return true;
		if (index == nums.length) {
			index = 0;
			index2++;
			qnums = nums.clone();
			qless.clear();
			qmore.clear();
			for (int i : nums) {
				qmore.add(i);
			}
		}
		if ((qnums[index] & (1 << index2)) == 0) {
			qless.add(qnums[index]);
			qmore.remove((Integer) qnums[index]);
		}
		for (int i = 0; i < qless.size(); i++) {
			nums[i] = qless.get(i);
		}
		for (int i = 0; i < qmore.size(); i++) {
			nums[i + qless.size()] = qmore.get(i);
		}
		index++;
		return false;
	}

    public boolean bitonic() {
    	//doesn't work :(
    	if (!fixed) {
    		index2 = 1;
    		index3 = 2;
    		fixed = true;
    	}
    	
    	int l = index ^ index2;
    	println(index,index2,index3,l);
    	if (l > index) {
    		if (((index & index3) == 0 && nums[index] > nums[l]
    		  || (index & index3) != 0 && nums[index] < nums[l])) {
    			int temp = nums[index];
    			nums[index] = nums[l];
    			nums[l] = temp;
    		}
    	}
    	
    	index++;
    	if (index == terms) {
    		index = 0;
    		index2 = floor(index2 / 2);
    	}
    	if (index2 == 0) {
    		index2 = index3 / 2;
    		index3 *= 2;
    	}
    	if (index3 > terms) {
    		return true;
    	} else {
    		return false;
    	}
    }
    
    public void show(boolean done) {
    	for (int i = 0; i < nums.length; i++) {
    		if (done) {
    			fill(255,0,255);
    		} else if (nums[i] == pivot) {
    			fill(0,0,255);
    		} else if (i == index) {
    			fill(255,0,0);
    		} else {
    			fill(255);
    		}
    		rect(i * (width / nums.length), height, width / nums.length, -nums[i] * (height/nums.length));
    	}
    }
    
    public void draw(){
        background(0);
        boolean completed = false;
        for (int i = 0; i < speed && !completed; i++) {
        	completed = bitonic();//radix(ceil(log(terms)/log(2)));
        }
        if (completed) {
        	show(true);
        	noLoop();
        } else {
        	show(false);
        }
    }
    
    public static void main(String[] args) {
        PApplet.main("test");
    }

    public void settings(){
        size(500, 500);
    }
}