package models;

public class MoveStraight implements CommandAction {
  private final MarsRover marsRover;

  public MoveStraight(MarsRover marsRover) {
    this.marsRover = marsRover;
  }

  public void execute() {
    switch (marsRover.getDirection()) {
      case 'E':
        marsRover.moveEast();
        break;
      case 'S':
        marsRover.moveSouth();
        break;
      case 'W':
        marsRover.moveWest();
        break;
      case 'N':
        marsRover.moveNorth();
        break;
    }
  }
}
