package models;

public class MoveStraight implements CommandAction {
  private final MarsRover marsRover;

  public MoveStraight(MarsRover marsRover) {
    this.marsRover = marsRover;
  }

  public void execute() {
    marsRover.move();
  }
}
