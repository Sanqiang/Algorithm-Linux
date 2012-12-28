package MaxBlackSubsquare;

public class Cell {
	public int blackAbove = 0;
	public int blackLeft = 0;
	public int bestSquareSize = 0;
	public int row = 0;
	public int col = 0;
	
	public Cell(int r, int c) {
		row = r;
		col = c;
	}
	
	public void incrementAbove() {
		blackAbove++;
	}
	
	public void incrementLeft() {
		blackLeft++;
	}
	
	public int shortest() {
		return Math.min(blackAbove, blackLeft);
	}
	
	public void print() {
		System.out.println("(" + row + ", " + col + "): " + bestSquareSize);
	}
}
