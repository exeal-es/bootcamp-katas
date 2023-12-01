import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

public class SnakeAndLaddersTest {

	@Test
	public void shouldAdvanceTwoSquareWhenDiceSumTwo (){
		SnakeAndLadders snakeAndLadders = new SnakeAndLadders();
		String result = snakeAndLadders.play(1, 1);
		assertThat(result).isEqualTo("Player 1 is on square 2");
	}
}
