package models;

public class MoveStraight implements CommandAction {
  private final MarsRover marsRover;

  public MoveStraight(MarsRover marsRover) {
    this.marsRover = marsRover;
  }

  public void execute() {
    boolean obstacleFound = false;
    switch (marsRover.getDirection()) {
      case 'E':
        obstacleFound = moveEast();
        break;
      case 'S':
        obstacleFound = moveSouth();
        break;
      case 'W':
        obstacleFound = moveWest();
        break;
      case 'N':
        obstacleFound = moveNorth();
        break;
    }
    marsRover.setObstacleFound(obstacleFound);
  }

  private boolean moveEast() {
    boolean obstacleFound;
    obstacleFound = marsRover.containsObstacle(marsRover.getX() + 1, marsRover.getY());
    // check if rover reached plateau limit or found an obstacle
    marsRover.setX(
        marsRover.getX() < 9 && !obstacleFound ? marsRover.getX() + 1 : marsRover.getX());
    return obstacleFound;
  }

  private boolean moveNorth() {
    boolean obstacleFound;
    obstacleFound = marsRover.containsObstacle(marsRover.getX(), marsRover.getY() - 1);
    // check if rover reached plateau limit or found an obstacle
    marsRover.setY(
        marsRover.getY() > 0 && !obstacleFound ? marsRover.getY() - 1 : marsRover.getY());
    return obstacleFound;
  }

  private boolean moveWest() {
    boolean obstacleFound;
    obstacleFound = marsRover.containsObstacle(marsRover.getX() - 1, marsRover.getY());
    // check if rover reached plateau limit or found an obstacle
    marsRover.setX(
        marsRover.getX() > 0 && !obstacleFound ? marsRover.getX() - 1 : marsRover.getX());
    return obstacleFound;
  }

  private boolean moveSouth() {
    boolean obstacleFound;
    obstacleFound = marsRover.containsObstacle(marsRover.getX(), (marsRover.getY() + 1));
    // check if rover reached plateau limit or found an obstacle
    marsRover.setY(
        marsRover.getY() < 9 && !obstacleFound ? marsRover.getY() + 1 : marsRover.getY());
    return obstacleFound;
  }
}
