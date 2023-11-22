package models;

public enum Direction {
  E,
  W,
  N,
  S;

  public int moveX(int x) {
    if (this == E) {
      return x + 1;
    }
    if (this == W) {
      return x - 1;
    }
    return x;
  }

  public int moveY(int y) {
    if (this == N) {
      return y - 1;
    }
    if (this == S) {
      return y + 1;
    }
    return y;
  }

  public static Direction parse(char direction) {
    if (direction == 'E') {
      return E;
    }
    if (direction == 'W') {
      return W;
    }
    if (direction == 'N') {
      return N;
    }
    return S;
  }
}
