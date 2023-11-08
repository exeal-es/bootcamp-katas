import models.Dimension;
import models.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BoardTest {

  @Test
  public void shouldReturnIsNotExploded() {
    // given
    Board board = new Board(new Dimension(1, 1));

    // when
    boolean hasExploded = board.play(new Position(0, 0));

    // then
    Assertions.assertFalse(hasExploded);
  }

  @Test
  public void shouldReturnIsExploded() {

    Board board = new Board(new Dimension(1, 1));

    board.placeMine(new Position(0, 0));
    boolean hasExploded = board.play(new Position(0, 0));

    Assertions.assertTrue(hasExploded);
  }
}
