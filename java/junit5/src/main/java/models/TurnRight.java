package models;

public class TurnRight implements CommandAction {
    private final MarsRover marsRover;

    public TurnRight(MarsRover marsRover) {
        this.marsRover = marsRover;
    }

    public void execute() {
        // get new direction
        int currentDirectionPosition = marsRover.getAvailableDirections().indexOf(marsRover.getDirection());
        if (currentDirectionPosition != 3) {
            marsRover.setDirection(marsRover.getAvailableDirections().charAt(currentDirectionPosition + 1));
        } else {
            marsRover.setDirection(marsRover.getAvailableDirections().charAt(0));
        }
    }
}