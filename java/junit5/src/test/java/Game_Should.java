import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import models.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Game_Should {
  private Game game;

  @BeforeEach
  public void InitializeGame() {
    game = new Game();
  }

  @Test
  public void NotAllowPlayerOToPlayFirst() {
    assertThrows(Exception.class, () -> game.Play('O', new Position(0, 0)));
  }

  @Test
  public void NotAllowPlayerXToPlayTwiceInARow() {
    assertThrows(
        Exception.class,
        () -> {
          game.Play('X', new Position(0, 0));
          game.Play('X', new Position(1, 0));
        });
  }

  @Test
  public void NotAllowPlayerToPlayInLastPlayedPosition() {
    assertThrows(
        Exception.class,
        () -> {
          game.Play('X', new Position(0, 0));
          game.Play('O', new Position(0, 0));
        });
  }

  @Test
  public void NotAllowPlayerToPlayInAnyPlayedPosition() {
    assertThrows(
        Exception.class,
        () -> {
          game.Play('X', new Position(0, 0));
          game.Play('O', new Position(1, 0));
          game.Play('X', new Position(0, 0));
        });
  }

  @Test
  public void DeclarePlayerXAsAWinnerIfThreeInTopRow() throws Exception {
    game.Play('X', new Position(0, 0));
    game.Play('O', new Position(1, 0));
    game.Play('X', new Position(0, 1));
    game.Play('O', new Position(1, 1));
    game.Play('X', new Position(0, 2));

    char winner = game.Winner();

    assertEquals('X', winner);
  }

  @Test
  public void DeclarePlayerOAsAWinnerIfThreeInTopRow() throws Exception {
    game.Play('X', new Position(2, 2));
    game.Play('O', new Position(0, 0));
    game.Play('X', new Position(1, 0));
    game.Play('O', new Position(0, 1));
    game.Play('X', new Position(1, 1));
    game.Play('O', new Position(0, 2));

    char winner = game.Winner();

    assertEquals('O', winner);
  }

  @Test
  public void DeclarePlayerXAsAWinnerIfThreeInMiddleRow() throws Exception {
    game.Play('X', new Position(1, 0));
    game.Play('O', new Position(0, 0));
    game.Play('X', new Position(1, 1));
    game.Play('O', new Position(0, 1));
    game.Play('X', new Position(1, 2));

    char winner = game.Winner();

    assertEquals('X', winner);
  }

  @Test
  public void DeclarePlayerOAsAWinnerIfThreeInMiddleRow() throws Exception {
    game.Play('X', new Position(0, 0));
    game.Play('O', new Position(1, 0));
    game.Play('X', new Position(2, 0));
    game.Play('O', new Position(1, 1));
    game.Play('X', new Position(2, 1));
    game.Play('O', new Position(1, 2));

    char winner = game.Winner();

    assertEquals('O', winner);
  }

  @Test
  public void DeclarePlayerXAsAWinnerIfThreeInBottomRow() throws Exception {
    game.Play('X', new Position(2, 0));
    game.Play('O', new Position(0, 0));
    game.Play('X', new Position(2, 1));
    game.Play('O', new Position(0, 1));
    game.Play('X', new Position(2, 2));

    char winner = game.Winner();

    assertEquals('X', winner);
  }

  @Test
  public void DeclarePlayerOAsAWinnerIfThreeInBottomRow() throws Exception {
    game.Play('X', new Position(0, 0));
    game.Play('O', new Position(2, 0));
    game.Play('X', new Position(1, 0));
    game.Play('O', new Position(2, 1));
    game.Play('X', new Position(1, 1));
    game.Play('O', new Position(2, 2));

    char winner = game.Winner();

    assertEquals('O', winner);
  }
}
