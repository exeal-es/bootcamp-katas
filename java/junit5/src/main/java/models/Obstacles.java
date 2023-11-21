package models;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class Obstacles {
  private final List<Obstacle> obstacles;

  public Obstacles(String[] obstacles) {
    this.obstacles = Arrays.stream(obstacles).map(Obstacle::new).collect(Collectors.toList());
  }

  public boolean collidePosition(int x, int y) {
    return obstacles.stream().anyMatch(obstacle -> obstacle.collidePosition(x, y));
  }
}
