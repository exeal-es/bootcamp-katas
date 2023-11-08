import models.Dimension;
import models.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BoardTest {

  @Test
  public void shouldReturnIsNotExplodedIn1x1Board() {
    // given
    Board board = new Board(new Dimension(1, 1));

    // when
    boolean hasExploded = board.play(new Position(0, 0));

    // then
    Assertions.assertFalse(hasExploded);
  }

  @Test
  public void shouldReturnIsExplodedIn1x1Board() {
    // given
    Board board = new Board(new Dimension(1, 1));

    // when
    board.placeMine(new Position(0, 0));
    boolean hasExploded = board.play(new Position(0, 0));

    // then
    Assertions.assertTrue(hasExploded);
  }

  @Test
  public void shouldReturnIsNotExplodedIn2x2Board() {
    // given
    Board board = new Board(new Dimension(2, 2));

    // when
    board.placeMine(new Position(0, 0));
    boolean hasExploded =  board.play(new Position(1, 1));

    // then
    Assertions.assertFalse(hasExploded);
  }

  @Test
  public void shouldReturnIsExplodedIn2x2BoardWith2Mines() {
    // given
    Board board = new Board(new Dimension(4, 4));

    // when
    board.placeMine(new Position(0, 0));
    board.placeMine(new Position(1, 1));
    boolean hasExploded =  board.play(new Position(0, 0));

    // then
    Assertions.assertTrue(hasExploded);
  }
}
