import models.Position;

public class Game {
  private char _lastSymbol = ' ';
  private Board _board = new Board();

  public void Play(char symbol, Position position) throws Exception {

    ensureFirstPlayerIsX(symbol);
    ensureIsTurnOf(symbol);
    ensurePositionIsFree(position);

    // update game state
    _lastSymbol = symbol;
    _board.AddTileAt(symbol, new Position(position.x(), position.y()));
  }

  private void ensurePositionIsFree(Position position) throws Exception {
    // if not first move but play on an already played tile
    if (_board.TileAt(new Position(position.x(), position.y())).Symbol != ' ') {
      throw new Exception("Invalid position");
    }
  }

  private void ensureIsTurnOf(char symbol) throws Exception {
    // if not first move but player repeated
    if (symbol == _lastSymbol) {
      throw new Exception("Invalid next player");
    }
  }

  private void ensureFirstPlayerIsX(char symbol) throws Exception {
    // if first move
    if (_lastSymbol == ' ' && symbol == 'O') {
      // if player is X
      throw new Exception("Invalid first player");
    }
  }

  public char Winner() {
    // if the positions in first row are taken
    if (isNotEmpty(new Position(0, 0))
        && isNotEmpty(new Position(0, 1))
        && isNotEmpty(new Position(0, 2))) {
      // if first row is full with same symbol
      if (_board.TileAt(new Position(0, 0)).Symbol == _board.TileAt(new Position(0, 1)).Symbol
          && _board.TileAt(new Position(0, 2)).Symbol == _board.TileAt(new Position(0, 1)).Symbol) {
        return _board.TileAt(new Position(0, 0)).Symbol;
      }
    }

    // if the positions in first row are taken
    if (isNotEmpty(new Position(1, 0))
        && isNotEmpty(new Position(1, 1))
        && isNotEmpty(new Position(1, 2))) {
      // if middle row is full with same symbol
      if (_board.TileAt(new Position(1, 0)).Symbol == _board.TileAt(new Position(1, 1)).Symbol
          && _board.TileAt(new Position(1, 2)).Symbol == _board.TileAt(new Position(1, 1)).Symbol) {
        return _board.TileAt(new Position(1, 0)).Symbol;
      }
    }

    // if the positions in first row are taken
    if (isNotEmpty(new Position(2, 0))
        && isNotEmpty(new Position(2, 1))
        && isNotEmpty(new Position(2, 2))) {
      // if middle row is full with same symbol
      if (_board.TileAt(new Position(2, 0)).Symbol == _board.TileAt(new Position(2, 1)).Symbol
          && _board.TileAt(new Position(2, 2)).Symbol == _board.TileAt(new Position(2, 1)).Symbol) {
        return _board.TileAt(new Position(2, 0)).Symbol;
      }
    }

    return ' ';
  }

  private boolean isNotEmpty(Position position) {
    return _board.TileAt(position).Symbol != ' ';
  }
}
