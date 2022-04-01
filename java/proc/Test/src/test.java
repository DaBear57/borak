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
	static int index4 = 0;
	static int vis1 = -1;
	static int vis2 = -1;
	static int pivot = 0;
	static int speed = 3;
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
	
	public void backwards() {
		for (int i = 0; i < nums.length; i++) {
			nums[i] = terms-i-1;
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
        vis1 = index;
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
    	vis1 = index;
    	vis2 = index2;
    	return progress == nums.length - 1;
    }
<<<<<<< HEAD
    
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
    			vis2 = qstarts.get(0);
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
    	
    	vis1 = index;
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
=======

	public boolean radix(int bits) {
		if (index2 == bits) return true
>>>>>>> 7ca78a19b28722688a6bca7e7df39bcfd02ca685
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
<<<<<<< HEAD
		if ((qnums[index] & (1 << index2)) == 0) {
=======
		if (qnums[index] & (1 << index)) {
>>>>>>> 7ca78a19b28722688a6bca7e7df39bcfd02ca685
			qless.add(qnums[index]);
			qmore.remove((Integer) qnums[index]);
		}
		for (int i = 0; i < qless.size(); i++) {
			nums[i] = qless.get(i);
		}
<<<<<<< HEAD
		for (int i = 0; i < qmore.size(); i++) {
			nums[i + qless.size()] = qmore.get(i);
		}
		index++;
		vis1 = index;
		return false;
	}

    public boolean bitonic() {
    	while (true) {
	    	if (!fixed) {
	    		index4 = 1;
	    		index3 = 1;
	    		fixed = true;
	    	}
	    	
	    	if ((index2 + index) / (index4 * 2) == (index2 + index + index3) / (index4 * 2)) {
	    		if (nums[index2 + index] > nums[index2 + index + index3]) {
	    			int temp = nums[index2 + index];
	    			nums[index2 + index] = nums[index2 + index + index3];
	    			nums[index2 + index + index3] = temp;
	    			break;
	    		}
	    	}
	    	
	    	index++;
	    	if (index >= terms - index2 - index3) {
	    		index2 += 2 * index3;
	    		index = 0;
	    	}
	    	if (index2 >= terms - index3) {
	    		index3 /= 2;
	    		index2 = index3 % index4;
	    	}
	    	if (index3 == 0) {
	    		index4 *= 2;
	    		index3 = index4;
	    	}
	    	if (index4 >= terms) {
	    		return true;
	    	}
    	}
    	vis1 = index2 + index;
    	vis2 = index2 + index + index3;
    	return false;
    }
=======
		for (int i = 0; i < nums.length; i++) {
			nums[i] = qmore.get(i + qless.size());
		}
		index++;
		return false;
	}
>>>>>>> 7ca78a19b28722688a6bca7e7df39bcfd02ca685
    
    public void show(boolean done) {
    	for (int i = 0; i < nums.length; i++) {
    		if (done) {
    			fill(255,0,255);
    		} else if (i == vis1) {
    			fill(255,0,0);
    		} else if (i == vis2) {
    			fill(0,255,0);
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