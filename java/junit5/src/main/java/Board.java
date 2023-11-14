import models.Position;

import java.util.ArrayList;
import java.util.List;

public class Board {
  private List<Tile> _plays = new ArrayList<>();

  public Board() {
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        Tile tile = new Tile();
        tile.X = i;
        tile.Y = j;
        tile.Symbol = ' ';
        _plays.add(tile);
      }
    }
  }

  public Tile TileAt(Position position) {
    for (Tile t : _plays) {
      if (t.X == position.getX() && t.Y == position.getY()) {
        return t;
      }
    }
    return null;
  }

  public void AddTileAt(char symbol, Position position) {
    Tile newTile = new Tile();
    newTile.X = position.getX();
    newTile.Y = position.getY();
    newTile.Symbol = symbol;

    TileAt(new Position(position.getX(), position.getY())).Symbol = symbol;
  }
}
