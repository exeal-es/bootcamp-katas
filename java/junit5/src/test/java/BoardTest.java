import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BoardTest {

  @Test
  public void shouldReturnIsNotExploded() {
    // given
    Board board = new Board(1, 1);

    // when
    boolean hasExploded = board.play(0, 0);

    // then
    Assertions.assertFalse(hasExploded);
  }

  @Test
  public void shouldReturnIsExploded() {

    Board board = new Board(1, 1);

    board.placeMine(0, 0);
    boolean hasExploded = board.play(0, 0);

    Assertions.assertTrue(hasExploded);
  }
}
