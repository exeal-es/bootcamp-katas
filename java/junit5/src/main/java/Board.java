import models.Dimension;
import models.Position;

public class Board {

  private boolean mine;

  public Board(Dimension dimension) {}

  public boolean play(Position position) {
    return mine;
  }

  public void placeMine(Position position) {
    mine = true;
  }
}
