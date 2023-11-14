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
    if (symbolAt(new Position(position.x(), position.y())) != ' ') {
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
    if (isRowTaken(0) && isFirstRowFullWithSameSymbol())  {
      return symbolAt(new Position(0, 0));
    }

    if (isRowTaken(1) && isMiddleRowFullWithSameSymbol()) {
      return symbolAt(new Position(1, 0));
    }

    if (isRowTaken(2) && isThirdRowFullWithSameSymbol()) {
      return symbolAt(new Position(2, 0));
    }

    return ' ';
  }

  private boolean isThirdRowFullWithSameSymbol() {
    return symbolAt(new Position(2, 0)) == symbolAt(new Position(2, 1))
        && symbolAt(new Position(2, 2)) == symbolAt(new Position(2, 1));
  }

  private boolean isMiddleRowFullWithSameSymbol() {
    return symbolAt(new Position(1, 0)) == symbolAt(new Position(1, 1))
        && symbolAt(new Position(1, 2)) == symbolAt(new Position(1, 1));
  }

  private boolean isFirstRowFullWithSameSymbol() {
    return symbolAt(new Position(0, 0)) == symbolAt(new Position(0, 1))
        && symbolAt(new Position(0, 2)) == symbolAt(new Position(0, 1));
  }

  private char symbolAt(Position position) {
    return _board.TileAt(position).Symbol;
  }

  private boolean isRowTaken(int x) {
    return !isEmpty(new Position(x, 0))
            && !isEmpty(new Position(x, 1))
            && !isEmpty(new Position(x, 2));
  }

  private boolean isEmpty(Position position) {
    return !(symbolAt(position) != ' ');
  }
}
