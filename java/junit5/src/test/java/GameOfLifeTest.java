import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameOfLifeTest {

	@Test
	public void shouldReturnNextGeneration() {
		Grid previousGrid = new Grid(1);
		Grid grid = previousGrid.nextGeneration();
		Assertions.assertThat(grid.width())
			.isEqualTo(1);
		Assertions.assertThat(grid.height())
			.isEqualTo(1);
		Assertions.assertThat(grid.isAlive(0, 0))
			.isEqualTo(false);
	}

	@Test
	public void shouldKeepGridWidth() {
		Grid previousGrid = new Grid(2);
		Grid grid = previousGrid.nextGeneration();
		Assertions.assertThat(grid.width())
				.isEqualTo(2);
	}
}
