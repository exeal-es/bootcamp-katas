public class SnakeAndLadders {
    private int turn = 0;
    private int positionPlayer1 = 0;
    private int positionPlayer2 = 0;
    private boolean gameOver = false;

    public String play(int die1, int die2) {
        if (gameOver) return "Game over!";

        if (turn == 1) {
            turn = 2;
            positionPlayer2 += die1 + die2;
            if (positionPlayer2 == 100) {
                gameOver = true;
                return "Player 2 Wins!";
            }
            return "Player " + turn + " is on square " + positionPlayer2;
        }

        turn = 1;
        positionPlayer1 += die1 + die2;

        if (positionPlayer1 == 100) {
            return "Player 1 Wins!";
        }
        return "Player " + turn + " is on square " + positionPlayer1;


    }
}
