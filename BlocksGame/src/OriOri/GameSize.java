package OriOri;


public class GameSize {
	public GameSize() {
	}

	// return game screen which is our grid.
	public static char[][] getGrid() {
		char grid[][] = new char[22][35]; // Game size 
		// Draw the borders.
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (j == 0 || grid[0].length - 1 == j || i == grid.length - 1
						|| i == 0)
					grid[i][j] = '*';
				else
					grid[i][j] = ' ';

			}
		}
		return grid;
	}

	//Updating grid table for each move- the method deletes ball's and paddle'shistory.
	public char[][] deleteX(char[][] grid, int[][] p) {

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 'x' || grid[i][j] == 'o')
					grid[i][j] = ' ';
			}
		}
		return grid;
	}

	//Adds the paddle, ball and bricks to the grid.
	public char[][] addShape(char[][] grid, int[][] p, char c) {
		for (int i = 0; i < p.length - 1; i++) {
			grid[p[i][0]][p[i][1]] = c;
		}
		return grid;
	}

	//Prints grid to console
	public void printGrid(char[][] grid) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				System.out.print(grid[i][j]);
			}
			System.out.println();
		}
	}
}
