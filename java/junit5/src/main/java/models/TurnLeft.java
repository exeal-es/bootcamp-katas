package models;

public class TurnLeft implements CommandAction {
  private final MarsRover marsRover;

  public TurnLeft(MarsRover marsRover) {
    this.marsRover = marsRover;
  }

  public void execute() {
    // get new direction
    int currentDirectionPosition =
        marsRover.getAvailableDirections().indexOf(marsRover.getDirection());
    if (currentDirectionPosition != 0) {
      marsRover.setDirection(
          marsRover.getAvailableDirections().charAt(currentDirectionPosition - 1));
    } else {
      marsRover.setDirection(marsRover.getAvailableDirections().charAt(3));
    }
  }
}
