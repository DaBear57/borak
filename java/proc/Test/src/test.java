import java.util.ArrayList;
import processing.core.*;

public class test extends PApplet {
	static int[] nums = new int[500];
	static int[] inums = new int[500];
	static int[] qnums = new int[500];
	static ArrayList<Integer> qstack = new ArrayList<Integer>();
	static int index = 0;
	static int index2 = 0;
	static int pivot = 0;
	static int speed = 100;
	static int progress = 0;

    public void setup(){
    	noStroke();
    	frameRate(60);
        for (int i = 0; i < nums.length; i++) {
        	nums[i] = (int) random(nums.length);
        }
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

	public boolean radix(int bits) {
		if (index2 == bits) return true
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
		if (qnums[index] & (1 << index)) {
			qless.add(qnums[index]);
			qmore.remove((Integer) qnums[index]);
		}
		for (int i = 0; i < qless.size(); i++) {
			nums[i] = qless.get(i);
		}
		for (int i = 0; i < nums.length; i++) {
			nums[i] = qmore.get(i + qless.size());
		}
		index++;
		return false;
	}
    
    public void show(boolean done) {
    	for (int i = 0; i < nums.length; i++) {
    		if (done) {
    			fill(0,255,0);
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
        	completed = insertion();
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