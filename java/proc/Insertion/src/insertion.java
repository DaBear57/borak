import processing.core.PApplet;

public class insertion extends PApplet {
	static int[] nums = new int[100];
	static int index = 0;
	static int speed = 25;
	static int progress = 0;

    public void setup(){
    	noStroke();
        for (int i = 0; i < nums.length; i++) {
        	nums[i] = (int) random(100);
        }
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
        for (int i = 0; i < speed; i++) {
	        progress++;
	        int[] nums2 = nums.clone();
	        for (index = 0; nums[progress] > nums[index]; i++) {}
	        for ()
	        
        }
        if (progress == 99) {
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