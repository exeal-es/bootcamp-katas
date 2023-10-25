public class Grid {

	public Grid nextGeneration() {
		return new Grid();
	}

	public int width() {
		return 1;
	}

	public int height() {
		return 1;
	}

	public boolean isAlive(int x, int y) {
		return false;
	}

}
