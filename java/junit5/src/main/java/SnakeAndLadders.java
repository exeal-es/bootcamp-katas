public class SnakeAndLadders {
	private int turn = 0;
	public String play(int die1, int die2) {

		turn++;
		return "Player " + turn + " is on square " + (die1+die2);
	}
}
