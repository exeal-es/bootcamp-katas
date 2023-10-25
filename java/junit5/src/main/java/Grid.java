public class Grid {

	private final int width;
	private final int height;
	private boolean[][] grid;

	public Grid(int width, int height) {
		this.width = width;
		this.height = height;
		this.grid = new boolean[width][height];
	}

	public Grid(boolean[][] grid) {
		this.width = grid.length;
		this.height = grid[0].length;
		this.grid = grid;
	}

	public Grid nextGeneration() {
		return new Grid(grid);
	}

	public int width() {
		return width;
	}

	public int height() {
		return height;
	}

	public boolean isAlive(int x, int y) {
		return grid[x][y];
	}

	public void setAlive(int x, int y) {
		grid[x][y] = true;
	}
}
