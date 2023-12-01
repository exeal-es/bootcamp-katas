import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

public class SnakeAndLaddersTest {

    @Test
    public void shouldAdvanceTwoSquareWhenDiceSumTwo() {
        SnakeAndLadders snakeAndLadders = new SnakeAndLadders();
        String result = snakeAndLadders.play(1, 1);
        assertThat(result).isEqualTo("Player 1 is on square 2");
    }

    @Test
    public void shouldAdvanceTwoSquareWhenDiceSumTwoAndIsTurnOfPlayer2() {
        SnakeAndLadders snakeAndLadders = new SnakeAndLadders();
        snakeAndLadders.play(1, 1);
        String resultPlayer2 = snakeAndLadders.play(1, 1);
        assertThat(resultPlayer2).isEqualTo("Player 2 is on square 2");
    }

    @Test
    public void shouldAlternateTurnBetweenPlayer1AndPlayer2() {
        SnakeAndLadders snakeAndLadders = new SnakeAndLadders();
        snakeAndLadders.play(1, 1);
        snakeAndLadders.play(1, 1);
        String turnPlayer1 = snakeAndLadders.play(1, 1);
        assertThat(turnPlayer1).isEqualTo("Player 1 is on square 4");
    }

    @Test
    public void shouldAlternateTurnBetweenPlayer1AndPlayer2Twice() {
        SnakeAndLadders snakeAndLadders = new SnakeAndLadders();
        snakeAndLadders.play(1, 1);
        snakeAndLadders.play(1, 1);
        snakeAndLadders.play(1, 1);
        String turnPlayer2 = snakeAndLadders.play(1, 1);
        assertThat(turnPlayer2).isEqualTo("Player 2 is on square 4");
    }

    @Test
    public void shouldPlayer1Win() {
        SnakeAndLadders snakeAndLadders = new SnakeAndLadders();

        String player1Result = snakeAndLadders.play(99, 1);

        assertThat(player1Result).isEqualTo("Player 1 Wins!");
    }

    @Test
    public void shouldPlayer2Win() {
        SnakeAndLadders snakeAndLadders = new SnakeAndLadders();

        snakeAndLadders.play(1, 1);
        String player2Result = snakeAndLadders.play(99, 1);

        assertThat(player2Result).isEqualTo("Player 2 Wins!");
    }

    @Test
    public void shouldFinishedTheGameWhenAPlayerWins() {
        SnakeAndLadders snakeAndLadders = new SnakeAndLadders();

        snakeAndLadders.play(1, 1);
        snakeAndLadders.play(99, 1);
        String resultThirdPlay = snakeAndLadders.play(1, 1);

        assertThat(resultThirdPlay).isEqualTo("Game over!");
    }

}
