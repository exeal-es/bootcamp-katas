import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

public class SnakeAndLaddersTest {

	@Test
	public void shouldAdvanceTwoSquareWhenDiceSumTwo (){
		SnakeAndLadders snakeAndLadders = new SnakeAndLadders();
		String result = snakeAndLadders.play(1, 1);
		assertThat(result).isEqualTo("Player 1 is on square 2");
	}
	@Test
	public void shouldAdvanceTwoSquareWhenDiceSumTwoAndIsTurnOfPlayer2 (){
		SnakeAndLadders snakeAndLadders = new SnakeAndLadders();
		String result = snakeAndLadders.play(1, 1);
		String resultPlayer2 = snakeAndLadders.play(1, 1);
		assertThat(resultPlayer2).isEqualTo("Player 2 is on square 2");
	}
}
