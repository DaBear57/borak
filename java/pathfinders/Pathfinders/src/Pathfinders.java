import java.util.ArrayList;

import processing.core.*;

public class Pathfinders extends PApplet {
	static Cell[][] cells = new Cell[25][25];
	static int cs = 20;
	static boolean start = false;
	Cell current;
	Cell destination;
	Cell beginning;
	
	public void noCornerCuts() {
		for (Cell[] row : cells) {
			for (Cell c : row) {
				for (int i = c.n.size() - 1; i >= 0; i--) {
					Cell n = c.n.get(i);
					if (c.x != n.x && c.y != n.y) {
						if (cells[c.y][n.x].isWall || cells[n.y][c.x].isWall) {
							c.n.remove(i);
						}
					}
				}
			}
		}
	}
	
	public void joinCells(Cell a, Cell b) {
		a.set = b.set;
		cells[(a.x + b.x) / 2][(a.y + b.y) / 2].isWall = false;
	}
	
	public void setup() {
		background(255,0,0);
		rect(10,10,60,60);
		for (int i = 0; i < cells.length; i++) {
			for (int j = 0; j < cells[0].length; j++) {
				cells[i][j] = new Cell(this,j,i);
			}
		}
		for (int i = 0; i < cells.length; i++) {
			for (int j = 0; j < cells[0].length - 1; j++) {
				cells[i][j].n.add(cells[i][j+1]);
				cells[i][j+1].n.add(cells[i][j]);
			}
		}
		for (int i = 0; i < cells.length - 1; i++) {
			for (int j = 0; j < cells[0].length; j++) {
				cells[i][j].n.add(cells[i+1][j]);
				cells[i+1][j].n.add(cells[i][j]);
			}
		}
		for (int i = 0; i < cells.length - 1; i++) {
			for (int j = 0; j < cells[0].length - 1; j++) {
				cells[i][j].n.add(cells[i+1][j+1]);
				cells[i+1][j+1].n.add(cells[i][j]);
			}
		}
		for (int i = 1; i < cells.length; i++) {
			for (int j = 0; j < cells[0].length - 1; j++) {
				cells[i][j].n.add(cells[i-1][j+1]);
				cells[i-1][j+1].n.add(cells[i][j]);
			}
		}
		beginning = cells[1][1];
		current = beginning;
		destination = cells[cells.length-2][cells[0].length-2];
		for (int i = 0; i < cells.length; i++) {
			for (int j = 0; j < cells[0].length; j++) {
				cells[i][j].g = cells[i][j].chebyshev(destination);
			}
		}
	}
	
	public void draw() {
		strokeWeight(1);
		for (int i = 0; i < cells.length; i++) {
			for (int j = 0; j < cells[0].length; j++) {
				cells[i][j].show(cs);
			}
		}
		strokeWeight(3);
		for (int i = 0; i < cells.length; i++) {
			for (int j = 0; j < cells[0].length; j++) {
				cells[i][j].arrow(cells[i][j].parent,false,cs);
			}
		}

		strokeWeight(1);
		fill(0,0,255);
		rect(current.x*cs,current.y*cs,cs,cs);
		
		fill(255,0,0);
		rect(beginning.x*cs,beginning.x*cs,cs,cs);
		
		fill(0,255,0);
		rect(destination.x*cs,destination.y*cs,cs,cs);
		
		if (mousePressed && !start) {
			int mx = constrain(mouseX,0,width);
			int my = constrain(mouseY,0,height);
			if (mouseButton == LEFT) {
				cells[my/cs][mx/cs].isWall = true;
			} else if (mouseButton == RIGHT) {
				cells[my/cs][mx/cs].isWall = false;
			}
		}
		
		if (start) {
			for (Cell neighbor : current.n) {
				if (neighbor.tdist > current.tdist + neighbor.euclidean(current) && !neighbor.isWall && !neighbor.isVisited) {
					neighbor.tdist = current.tdist + neighbor.euclidean(current);
					neighbor.parent = current;
				}
			}
			
			current.isVisited = true;
			if (destination.isVisited) {
				destination.showPath(cs);
				fill(255,0,0);
				rect(beginning.x * cs,beginning.x * cs,cs,cs);
				fill(0,255,0);
				rect(destination.x*cs,destination.y*cs,cs,cs);
				noLoop();
			}
			
			float bdist = 999999;
			Cell bcell = destination;
			for (int i = 0; i < cells.length; i++) {
				for (int j = 0; j < cells[0].length; j++) {
					//dijkstra
//					int cdist = cells[i][j].tdist;
					
					//a*
					float cdist = cells[i][j].tdist + cells[i][j].g;
					
					if (cdist < bdist && !cells[i][j].isVisited && !cells[i][j].isWall) {
						bdist = cdist;
						bcell = cells[i][j];
					}
				}
			}
			current = bcell;
		}
		
		if (!start && key == ' ' && keyPressed) {
			for (int i = 0; i < cells.length; i++) {
				for (int j = 0; j < cells[0].length; j++) {
					Cell c = cells[i][j];
					int count = c.nCount();
					if (c.isWall) {
						if (count > 5) c.stays = false;
					} else {
						if (count == 3) c.stays = false;
					}
				}
			}
			for (int i = 0; i < cells.length; i++) {
				for (int j = 0; j < cells[0].length; j++) {
					if (!cells[i][j].stays) {
						cells[i][j].isWall = !cells[i][j].isWall;
						cells[i][j].stays = true;
					}
				}
			}
		}
	}
	
	public void keyPressed() {
		if (!start && keyCode == ENTER) {
			start = true;
			current = beginning;
			current.tdist = 0;
			destination.isWall = false;
			noCornerCuts();
			return;
		}
		
		if (key == 'm') {
			//form grid
			int n = 0;
			for (int i = 1; i < cells.length; i++) {
				for (int j = 1; j < cells[0].length; j++) {
					if (!cells[i][j].isWall) {
						for (Cell neighbor : cells[i][j].n) {
							neighbor.isWall = true;
						}
						cells[i][j].set = n;
						n++;
					}
				}
			}
			
			//init list of edges
			ArrayList<Cell> edges = new ArrayList<Cell>();
			for (int i = 1; i < cells.length - 1; i++) {
				for (int j = 1; j < cells[0].length - 1; j++) {
					Cell c = cells[i][j];
					if (!c.isWall) continue;
					if (i % 2 == 1) {}
				}
			}
		}
	}
	
	public static void main(String[] args) {
        PApplet.main("Pathfinders");
    }

    public void settings(){
        size(500, 500);
    }
}
