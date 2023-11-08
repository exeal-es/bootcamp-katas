import models.Dimension;
import models.Position;

public class Board {

  private Position mine;

  public Board(Dimension dimension) {}

  public boolean play(Position position) {
    return position.equals(mine);
  }

  public void placeMine(Position position) {
    mine = position;
  }
}
