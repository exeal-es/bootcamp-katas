import models.Dimension;
import models.Position;

import java.util.ArrayList;
import java.util.List;

public class Board {

  private final List<Position> mines;

  public Board(Dimension dimension) {
    mines = new ArrayList<>();
  }

  public boolean play(Position position) {
    return mines.contains(position);
  }

  public void placeMine(Position position) { mines.add(position); }
}
