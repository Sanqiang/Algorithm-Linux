package MaxBlackSubsquare;

public class Question {
	public static int size = 10;
	
	public static boolean randomBoolean(int percentTrue) {
		return randomIntInRange(1, 100) <= percentTrue;
	}		
	
	public static int randomInt(int n) {
		return (int) (Math.random() * n);
	}
	
	public static int randomIntInRange(int min, int max) {
		return randomInt(max + 1 - min) + min;
	}
	
	public static void printMatrix(boolean[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j]) {
					System.out.print("1");
				} else {
					System.out.print("0");
				}
			}
			System.out.println();
		}
	}	
	
	public static boolean[][] createSquare() {
		boolean[][] square = new boolean[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				square[i][j] = randomBoolean(20);
			}
		}
		return square;
	}
	
	public static Cell[][] processSquare(boolean[][] square) {
		Cell[][] cells = new Cell[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				cells[i][j] = new Cell(i, j);
			}
		}
		
		for (int i = 0; i < size; i++) {
			int seriesRows = 0;
			for (int j = 0; j < size; j++) {
				if (square[i][j]) {
					seriesRows = 0;
				} else {
					seriesRows++;
				}
				cells[i][j].blackLeft = seriesRows;
			}
		}
		
		for (int i = 0; i < size; i++) {
			int seriesCols = 0;
			for (int j = 0; j < size; j++) {
				if (square[j][i]) {
					seriesCols = 0;
				} else {
					seriesCols++;
				}
				cells[j][i].blackAbove = seriesCols;
			}
		}
		
		return cells;
	}
	
	public static Cell bestCorner = null;
	
	public static void processDiagonal(Cell[][] cells, int row, int col) {
		int previousSize = 0;
		if (row > 0 && col > 0) {
			processDiagonal(cells, row - 1, col - 1);
			Cell previousCorner = cells[row - 1][col - 1];
			previousSize = previousCorner.bestSquareSize;
		}
		
		Cell corner = cells[row][col];
		if (corner.shortest() > previousSize) {
			corner.bestSquareSize = previousSize + 1;
		} else {
			corner.bestSquareSize = corner.shortest();
		}
		if (bestCorner == null || corner.bestSquareSize > bestCorner.bestSquareSize) {
			bestCorner = corner;
		}
	}
	
	public static void findMaxSquare(Cell[][] cells) {
		for (int c = 0; c < size; c++) {
			processDiagonal(cells, size - 1, c);
		}
		
		for (int r = 0; r < size; r++) {
			processDiagonal(cells, r, size - 1);
		}
		
	}
	
	
	
	public static void findMaxSquare(boolean[][] square) {
		Cell[][] cells = processSquare(square);
		findMaxSquare(cells);
		bestCorner.print();
	}
	
	public static void main(String[] args) {
		boolean[][] square = createSquare();
		printMatrix(square);
		findMaxSquare(square);
	}

}
