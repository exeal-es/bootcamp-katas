package models;

public final class Obstacle {

  private final int x;
  private final int y;

  public Obstacle(final String position) {
    final String[] positions = position.split(":");
    this.x = Integer.parseInt(positions[0]);
    this.y = Integer.parseInt(positions[1]);
  }

  public boolean isInPosition(int x, int y) {
    return this.x == x && this.y == y;
  }
}
