import java.util.ArrayList;

import processing.core.*;

public class Pathfinders extends PApplet {
	static Cell[][] cells = new Cell[129][229];
	static int cs;
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
	
	public void settings(){
        fullScreen();
    }
	
	public void setup() {
		cs = 7;
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
			for (int r = 0; r < 50; r++) {
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
						//float cdist = cells[i][j].tdist;
						
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
			ArrayList<Cell> edges = new ArrayList<Cell>();
			for (int i = 1; i < cells.length; i++) {
				for (int j = 1; j < cells[0].length; j++) {
					if (!cells[i][j].isWall) {
						for (Cell neighbor : cells[i][j].n) {
							neighbor.isWall = true;
						}
						cells[i][j].set = n;
						n++;
						
						ArrayList<Cell> pedges = new ArrayList<Cell>();
						pedges.add(cells[i+1][j]);
						pedges.add(cells[i][j+1]);
						pedges.add(cells[i-1][j]);
						pedges.add(cells[i][j-1]);
						
						for (int k = 0; k < pedges.size(); k++) {
							Cell pedge = pedges.get(k);
							if (pedge.x < 1 || pedge.x >= cells[0].length - 1 || pedge.y < 1 || pedge.y >= cells.length - 1) {
								continue;
							}
							if (edges.contains(pedge)) continue;
							edges.add(pedge);
							//-1 horiz, -2 vert
							pedge.set -= k % 2;
						}
					}
				}
			}
			
			//randomly remove borders
			for (
					int ie = floor(random(edges.size())); 
					edges.size() > 0; 
					ie = floor(random(edges.size()))
				) {
				Cell edge = edges.get(ie);
				//println(edge.set);
				//get bordering cells
				Cell n1 = cells[edge.y-1][edge.x];
				Cell n2 = cells[edge.y+1][edge.x];
				 if (edge.set == -2) {
					n1 = cells[edge.y][edge.x-1];
					n2 = cells[edge.y][edge.x+1];
				} else if (edge.set != -1) {
					println("real bad");
				}
				
				//remove border if in different sets
				if (n1.set != n2.set) {
					int old = n2.set;
					for (Cell[] row : cells) {
						for (Cell o : row) {
							if (o.set == old) o.set = n1.set;
						}
					}
					edge.isWall = false;
				}
				edges.remove(edge);
			}
		}
	}
	
	public static void main(String[] args) {
        PApplet.main("Pathfinders");
	}
}
