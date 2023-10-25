public class Grid {

	private int width;

	public Grid(int width) {
		this.width = width;
	}

	public Grid nextGeneration() {
		return new Grid(width);
	}

	public int width() {
		return width;
	}

	public int height() {
		return 1;
	}

	public boolean isAlive(int x, int y) {
		return false;
	}

}
