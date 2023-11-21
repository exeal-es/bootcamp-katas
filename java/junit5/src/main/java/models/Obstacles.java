package models;

public final class Obstacles {
  private final String[] obstacles;

  public Obstacles(String[] obstacles) {
    this.obstacles = obstacles;
  }

  public String[] getObstacles() {
    return obstacles;
  }

  public boolean contains(int x, int y) {
    for (String obstacle : obstacles) {
      if (obstacle.equals(x + ":" + y)) {
        return true;
      }
    }
    return false;
  }
}
