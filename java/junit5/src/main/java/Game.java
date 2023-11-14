import models.Position;

public class Game {
  private char _lastSymbol = ' ';
  private Board _board = new Board();

  public void Play(char symbol, Position position) throws Exception {
    // if first move
    if (_lastSymbol == ' ' && symbol == 'O') {
      // if player is X
      throw new Exception("Invalid first player");
    }
    // if not first move but player repeated
    if (symbol == _lastSymbol) {
      throw new Exception("Invalid next player");
    }
    // if not first move but play on an already played tile
    if (_board.TileAt(new Position(position.x(), position.y())).Symbol != ' ') {
      throw new Exception("Invalid position");
    }

    // update game state
    _lastSymbol = symbol;
    _board.AddTileAt(symbol, position.x(), position.y());
  }

  public char Winner() {
    // if the positions in first row are taken
    if (_board.TileAt(new Position(0, 0)).Symbol != ' '
        && _board.TileAt(new Position(0, 1)).Symbol != ' '
        && _board.TileAt(new Position(0, 2)).Symbol != ' ') {
      // if first row is full with same symbol
      if (_board.TileAt(new Position(0, 0)).Symbol == _board.TileAt(new Position(0, 1)).Symbol
          && _board.TileAt(new Position(0, 2)).Symbol == _board.TileAt(new Position(0, 1)).Symbol) {
        return _board.TileAt(new Position(0, 0)).Symbol;
      }
    }

    // if the positions in first row are taken
    if (_board.TileAt(new Position(1, 0)).Symbol != ' '
        && _board.TileAt(new Position(1, 1)).Symbol != ' '
        && _board.TileAt(new Position(1, 2)).Symbol != ' ') {
      // if middle row is full with same symbol
      if (_board.TileAt(new Position(1, 0)).Symbol == _board.TileAt(new Position(1, 1)).Symbol
          && _board.TileAt(new Position(1, 2)).Symbol == _board.TileAt(new Position(1, 1)).Symbol) {
        return _board.TileAt(new Position(1, 0)).Symbol;
      }
    }

    // if the positions in first row are taken
    if (_board.TileAt(new Position(2, 0)).Symbol != ' '
        && _board.TileAt(new Position(2, 1)).Symbol != ' '
        && _board.TileAt(new Position(2, 2)).Symbol != ' ') {
      // if middle row is full with same symbol
      if (_board.TileAt(new Position(2, 0)).Symbol == _board.TileAt(new Position(2, 1)).Symbol
          && _board.TileAt(new Position(2, 2)).Symbol == _board.TileAt(new Position(2, 1)).Symbol) {
        return _board.TileAt(new Position(2, 0)).Symbol;
      }
    }

    return ' ';
  }
}
