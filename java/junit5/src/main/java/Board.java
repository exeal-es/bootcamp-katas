import models.Position;

public class Board {

  private boolean mine;

  public Board(int x, int y) {}

  public boolean play(Position position) {
    return mine;
  }

  public void placeMine(Position position) {
    mine = true;
  }
}
