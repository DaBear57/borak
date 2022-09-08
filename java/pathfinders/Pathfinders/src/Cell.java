import java.util.ArrayList;

import processing.core.*;

public class Cell {
	int x; int y;
	PApplet p;
	boolean isWall;
	boolean isVisited;
	float tdist;
	ArrayList<Cell> n;
	Cell parent;
	float g;
	boolean stays;
	int set;
	
	public Cell(PApplet _p, int _x, int _y) {
		x = _x;
		y = _y;
		p = _p;
		isWall = false;
		isVisited = false;
		tdist = 99999;
		n = new ArrayList<Cell>();
		parent = null;
		stays = true;
		set = -1;
	}
	
	public void show(int cs) {
		p.fill(150);
		p.noStroke();
		if (!isVisited) p.fill(255);
		if (isWall) p.fill(0);
		p.rect(x*cs,y*cs,cs,cs);
	}
	
	public void arrow(Cell b, boolean isPath, int cs) {
		p.stroke(0);
		p.strokeWeight(3);
		if (isPath) {
			p.stroke(255,255,0);
			p.strokeWeight(5);
		}
		if (isVisited && parent != null) p.line(x * cs + cs/2, y * cs + cs/2, b.x * cs + cs/2, b.y * cs + cs/2);
	}
	
	public void showPath(int cs) {
		arrow(parent,true, cs);
		if (parent != null) {
			parent.showPath(cs);
		}
	}
	
	public int manhattan(Cell dest) {
		return p.abs(x - dest.x) + p.abs(y - dest.y);
	}
	
	public int chebyshev(Cell dest) {
		return p.max(p.abs(x - dest.x), p.abs(y - dest.y));
	}
	
	public float euclidean(Cell dest) {
		return p.sqrt(p.pow(x - dest.x, 2) + p.pow(y - dest.y, 2));
	}
	
	public int nCount() {
		int c = 0;
		for (Cell i : n) {
			if (i.isWall) c++;
		}
		return c;
	}
}
