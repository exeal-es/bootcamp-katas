public class SnakeAndLadders {
    private int turn = 0;
    private int positionPlayer1 = 0;
    private int positionPlayer2 = 0;

    public String play(int die1, int die2) {

        if (turn == 1) {
            turn = 2;
            positionPlayer2 += die1 + die2;
            return "Player " + turn + " is on square " + positionPlayer2;
        }
        turn = 1;
        positionPlayer1 += die1 + die2;
        return "Player " + turn + " is on square " + positionPlayer1;
    }
}
