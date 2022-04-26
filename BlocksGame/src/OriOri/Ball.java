package OriOri;

enum DIRECTION {
	UP, DOWN, UPRIGHT, UPLEFT, DOWNRIGHT, DOWNLEFT, WAIT
};

public class Ball {
	//Default move of ball is in the UP direction.
	DIRECTION dir = DIRECTION.UP;
	// Ball's initial location.
	int ball[][] = { { 18, 17 }, { 0, 0 } };
	//Borders of the the ball for redirection.
	int leftborder = 2;
	int rightborder = 32;
	int upperborder = 1;
	int lowerborder = 19;

	public Ball() {
	}

	public int[][] getBall() {
		return ball;
	}

	//Control for collision with bricks.
	public String control(char[][] grid, int[][] b) {
		for (int i = 0; i < b.length - 1; i++) {
			if (grid[b[i][0] - 1][b[i][1]] == 'W' && this.dir == DIRECTION.UP /* up */) {
				return "W_UP";
			} else if (grid[b[i][0] + 1][b[i][1]] == 'W'
					&& this.dir == DIRECTION.DOWN /* down */) {
				return "W_DOWN";
			} else if (grid[b[i][0] + 1][b[i][1] - 1] == 'W'
					&& this.dir == DIRECTION.DOWNLEFT/* left down cross */) {
				return "W_LDC";
			} else if (grid[b[i][0] - 1][b[i][1] - 1] == 'W'
					&& this.dir == DIRECTION.UPLEFT/* left up cross */) {
				return "W_LUC";
			} else if (grid[b[i][0] - 1][b[i][1] + 1] == 'W'
					&& this.dir == DIRECTION.UPRIGHT/* right up cross */) {
				return "W_RUC";
			} else if (grid[b[i][0] + 1][b[i][1] + 1] == 'W'
					&& this.dir == DIRECTION.DOWNRIGHT/* right down cross */) {
				return "W_RDC";
			} else if (grid[b[i][0]][b[i][1]] == 'x') {
				return "x";
			} else if (grid[b[i][0] - 1][b[i][1]] == 'Y'
					&& this.dir == DIRECTION.UP/* up */) {
				return "Y_UP";
			} else if (grid[b[i][0] + 1][b[i][1]] == 'Y'
					&& this.dir == DIRECTION.DOWN/* down */) {
				return "Y_DOWN";
			} else if (grid[b[i][0] + 1][b[i][1] - 1] == 'Y'
					&& this.dir == DIRECTION.DOWNLEFT/* left down cross */) {
				return "Y_LDC";
			} else if (grid[b[i][0] - 1][b[i][1] - 1] == 'Y'
					&& this.dir == DIRECTION.UPLEFT/* left up cross */) {
				return "Y_LUC";
			} else if (grid[b[i][0] - 1][b[i][1] + 1] == 'Y'
					&& this.dir == DIRECTION.UPRIGHT/* right up cross */) {
				return "Y_RUC";
			} else if (grid[b[i][0] + 1][b[i][1] + 1] == 'Y'
					&& this.dir == DIRECTION.DOWNRIGHT/* right down cross */) {
				return "Y_RDC";
			}
		}
		return "-1"; 
	}

	//When ball meets with a brick, they collide and ball simply deletes it.
	public char[][] deleteX(char[][] grid, int[][] b) {

		for (int i = 0; i < b.length - 1; i++) {
			if (grid[b[i][0] - 1][b[i][1]] == 'W' && this.dir == DIRECTION.UP/* up */) {
				grid[b[i][0] - 1][b[i][1]] = ' ';
			} else if (grid[b[i][0] + 1][b[i][1] - 1] == 'W'
					&& this.dir == DIRECTION.DOWNLEFT/* left down cross */) {
				grid[b[i][0] + 1][b[i][1] - 1] = ' ';
			} else if (grid[b[i][0] + 1][b[i][1] + 1] == 'W'
					&& this.dir == DIRECTION.DOWNRIGHT/* right down cross */) {
				grid[b[i][0] + 1][b[i][1] + 1] = ' ';
			} else if (grid[b[i][0] - 1][b[i][1] - 1] == 'W'
					&& this.dir == DIRECTION.UPLEFT/* left up cross */) {
				grid[b[i][0] - 1][b[i][1] - 1] = ' ';
			} else if (grid[b[i][0] - 1][b[i][1] + 1] == 'W'
					&& this.dir == DIRECTION.UPRIGHT/* right up cross */) {
				grid[b[i][0] - 1][b[i][1] + 1] = ' ';
			} else if (grid[b[i][0] + 1][b[i][1]] == 'W'
					&& this.dir == DIRECTION.DOWN /* down */) {
				grid[b[i][0] + 1][b[i][1]] = ' ';
			} else if (grid[b[i][0] - 1][b[i][1]] == 'Y'
					&& this.dir == DIRECTION.UP/* up */) {
				grid[b[i][0] - 1][b[i][1]] = ' '/* up itself */;
				grid[b[i][0] - 2][b[i][1]] = ' '/* two up */;
				grid[b[i][0] - 1][b[i][1] + 1] = ' '/* up right */;
				grid[b[i][0] - 1][b[i][1] - 1] = ' '/* up left */;
			} else if (grid[b[i][0] + 1][b[i][1]] == 'Y'
					&& this.dir == DIRECTION.DOWN/* down */) {
				grid[b[i][0] + 1][b[i][1]] = ' '/* down itself */;
				grid[b[i][0] + 2][b[i][1]] = ' '/* two down */;
				grid[b[i][0] + 1][b[i][1] + 1] = ' '/* down right */;
				grid[b[i][0] + 1][b[i][1] - 1] = ' '/* down left */;
			} else if (grid[b[i][0] + 1][b[i][1] - 1] == 'Y'
					&& this.dir == DIRECTION.DOWNLEFT/* left down cross */) {
				grid[b[i][0] + 1][b[i][1] - 1] = ' '/* down left cross */;
				grid[b[i][0] + 1][b[i][1] - 2] = ' '/* down left cross, left */;
				grid[b[i][0] + 1][b[i][1]] = ' '/* down */;
				grid[b[i][0] + 2][b[i][1] - 1] = ' '/* two down */;
				grid[b[i][0]][b[i][1] - 1] = ' '/* two down */;
			} else if (grid[b[i][0] + 1][b[i][1] + 1] == 'Y'
					&& this.dir == DIRECTION.DOWNRIGHT/* right down cross */) {
				grid[b[i][0] + 1][b[i][1] + 1] = ' '/* down right */;
				grid[b[i][0] + 1][b[i][1] + 2] = ' '/* down right right */;
				grid[b[i][0] + 1][b[i][1]] = ' '/* down itself */;
				grid[b[i][0] + 2][b[i][1] + 1] = ' '/* two down right */;
				grid[b[i][0]][b[i][1] + 1] = ' '/* down right */;
			} else if (grid[b[i][0] - 1][b[i][1] - 1] == 'Y'
					&& this.dir == DIRECTION.UPLEFT/* left up cross */) {
				grid[b[i][0] - 1][b[i][1] - 1] = ' '/* up left */;
				grid[b[i][0] - 2][b[i][1] - 1] = ' '/* two up left */;
				grid[b[i][0] - 1][b[i][1] - 2] = ' '/* up left left */;
				grid[b[i][0] - 1][b[i][1]] = ' '/* up itself */;
				grid[b[i][0]][b[i][1] - 1] = ' '/* up left */;
			} else if (grid[b[i][0] - 1][b[i][1] + 1] == 'Y'
					&& this.dir == DIRECTION.UPRIGHT/* right up cross */) {
				grid[b[i][0] - 1][b[i][1] + 1] = ' '/* up right */;
				grid[b[i][0] - 2][b[i][1] + 1] = ' '/* two up right */;
				grid[b[i][0] - 1][b[i][1] + 2] = ' '/* up right right */;
				grid[b[i][0] - 1][b[i][1]] = ' '/* up itself */;
				grid[b[i][0]][b[i][1] + 1] = ' '/* right */;
			}

		}
		return grid;
	}

	//The rules of the game
	public boolean bounce(char[][] grid, int[][] b) {
		//Array that contains paddle's location.
		int[][] paddle = Paddle.paddle; 
		for (int i = 0; i < b.length - 1; i++) {
			if (b[0][0] == 17) {
				//Column of the ball
				int ballColumn = b[0][1]; 

				//if any part of the paddle will touch the ball, bounce back.
				if (paddle[0][1] == ballColumn) {
					this.dir = DIRECTION.UPLEFT;
					break;
				} else if (paddle[0][1] == ballColumn + 2
						&& this.dir == DIRECTION.DOWNRIGHT) {
					this.dir = DIRECTION.UPLEFT;
					break;
				} else if (paddle[0][1] == ballColumn - 2
						&& this.dir == DIRECTION.DOWNLEFT) {
					this.dir = DIRECTION.UPLEFT;
					break;
				} else if (paddle[1][1] == ballColumn) {
					this.dir = DIRECTION.UP;
					break;
				} else if (paddle[1][1] == ballColumn + 2
						&& this.dir == DIRECTION.DOWNRIGHT) {
					this.dir = DIRECTION.UP;
					break;
				} else if (paddle[1][1] == ballColumn - 2
						&& this.dir == DIRECTION.DOWNLEFT) {
					this.dir = DIRECTION.UP;
					break;
				} else if (paddle[2][1] == ballColumn) {
					this.dir = DIRECTION.UPRIGHT;
					break;
				} else if (paddle[2][1] == ballColumn + 2
						&& this.dir == DIRECTION.DOWNRIGHT) {
					this.dir = DIRECTION.UPRIGHT;
					break;
				} else if (paddle[2][1] == ballColumn + 2
						&& this.dir == DIRECTION.DOWNLEFT) {
					this.dir = DIRECTION.UPRIGHT;
					break;
				}
				return true;
			}
		}
		return false;
	}

	// Ball up method increase row values till the upper borders.
	public int[][] ballUp(char[][] grid, int[][] b) {
		for (int i = 0; i < b.length - 1; i++) {
			// While ball is going UP, if it hits the upper border, it will be redirected to DOWN.
			if (b[i][0] == upperborder) {
				this.dir = DIRECTION.DOWN;
				break;
			} 
			else if (control(grid, b) == "W_UP") {
				deleteX(grid, b);
				this.dir = DIRECTION.DOWN;
				break;
			} 
			else if (control(grid, b) == "Y_UP") {
				deleteX(grid, b);
				this.dir = DIRECTION.DOWN;
				break;
			}
			b[i][0] -= 1;
		}
		return b;
	}

	// Ball down method decrease row values till lower the borders When the ball
	//pass the lower border than game will be over.
	public int[][] ballDown(char[][] grid, int[][] b) {
		for (int i = 0; i < b.length - 1; i++) {
			if (b[i][0] > lowerborder) { 
				System.out.println("GAME OVER!");
				System.exit(0);
				break;
			} else if (bounce(grid, b)) 
				;
			else if (control(grid, b) == "W_DOWN") {
				deleteX(grid, b);
				this.dir = DIRECTION.UP;
				break;
			} else if (control(grid, b) == "Y_DOWN") {
				deleteX(grid, b);
				this.dir = DIRECTION.UP;
				break;
			}
			b[i][0] += 1;
		}
		return b;
	}

	
	public int[][] ballRightUpCross(char[][] grid, int[][] b) {
		for (int i = 0; i < b.length - 1; i++) {
			if (b[i][0] == upperborder) { 
				this.dir = DIRECTION.DOWNRIGHT;
				break;
			} else if (b[i][1] > rightborder) { 
				this.dir = DIRECTION.UPLEFT;
				break;
			} else if (b[i][0] > lowerborder) { 
				System.out.println("GAME OVER!");
				System.exit(0);
			} else if (bounce(grid, b)) 
				;
			else if (control(grid, b) == "W_RUC") { 
				deleteX(grid, b);
				this.dir = DIRECTION.DOWNLEFT;
				break;
			} else if (control(grid, b) == "Y_RUC") { 
														
				deleteX(grid, b);
				this.dir = DIRECTION.DOWNLEFT;
				break;
			}
			b[i][0] -= 1;
			b[i][1] += 1;
		}
		return b;
	}

	
	public int[][] ballRightCrossDown(char[][] grid, int[][] b) {
		for (int i = 0; i < b.length - 1; i++) {
			if (b[i][0] > lowerborder) { 
				System.out.println("GAME OVER!");
				System.exit(0);
			}
			if (b[i][1] > rightborder) { 
				this.dir = DIRECTION.DOWNLEFT;
				break;
			} else if (bounce(grid, b)) 
				;
			else if (control(grid, b) == "W_RDC") { 
				deleteX(grid, b);
				this.dir = DIRECTION.UPLEFT;
				break;
			} else if (control(grid, b) == "Y_RDC") { 
														
				deleteX(grid, b);
				this.dir = DIRECTION.UPLEFT;
				break;
			}
			b[i][0] += 1;
			b[i][1] += 1;
		}
		return b;
	}

	
	public int[][] ballLeftUpCross(char[][] grid, int[][] b) {
		for (int i = 0; i < b.length - 1; i++) {
			if (b[i][0] > lowerborder) { //if the ball touches the bottom of the border.
				System.out.println("GAME OVER!");
				System.exit(0);
			} else if (b[i][0] == upperborder) { 
				this.dir = DIRECTION.DOWNLEFT;
				break;
			} else if (b[i][1] < leftborder) { 
				this.dir = DIRECTION.UPRIGHT;
				break;
			} else if (bounce(grid, b)) 
				;
			else if (control(grid, b) == "W_LUC") { 
				deleteX(grid, b);
				this.dir = DIRECTION.DOWNRIGHT;
				break;
			} else if (control(grid, b) == "Y_LUC") { 
														
				deleteX(grid, b);
				this.dir = DIRECTION.DOWNRIGHT;
				break;
			}
			b[i][0] -= 1;
			b[i][1] -= 1;
		}
		return b;
	}

	public int[][] ballLeftCrossDown(char[][] grid, int[][] b) {
		for (int i = 0; i < b.length - 1; i++) {
			if (b[i][0] > lowerborder) { //if the ball touches lower border.
				System.out.println("GAME OVER!");
				System.exit(0);
			} else if (b[i][1] < leftborder) { //if the ball touches left border.
				this.dir = DIRECTION.DOWNRIGHT;
				break;
			} else if (bounce(grid, b))
				; // Touches paddle.
			else if (control(grid, b) == "W_LDC") { 
				deleteX(grid, b);
				this.dir = DIRECTION.UPRIGHT;
				break;
			} else if (control(grid, b) == "Y_LDC") { 
														 
				deleteX(grid, b);
				this.dir = DIRECTION.UPRIGHT;
				break;
			}
			b[i][0] += 1;
			b[i][1] -= 1;
		}
		return b;
	}

	//Combining enumerator with our functions.
	public void move(char[][] grid, int[][] b) {
		if (this.dir == DIRECTION.UP) {
			ballUp(grid, b);
		} else if (this.dir == DIRECTION.DOWN) {
			ballDown(grid, b);
		} else if (this.dir == DIRECTION.UPLEFT) {
			ballLeftUpCross(grid, b);
		} else if (this.dir == DIRECTION.UPRIGHT) {
			ballRightUpCross(grid, b);
		} else if (this.dir == DIRECTION.DOWNLEFT) {
			ballLeftCrossDown(grid, b);
		} else if (this.dir == DIRECTION.DOWNRIGHT) {
			ballRightCrossDown(grid, b);
		}
		//Time interval between 2 move.
		try {
			Thread.sleep(100);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

}
