public class Grid {

	private final int width;
	private final int height;

	public Grid(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public Grid nextGeneration() {
		return new Grid(width, height);
	}

	public int width() {
		return width;
	}

	public int height() {
		return height;
	}

	public boolean isAlive(int x, int y) {
		return false;
	}

}
