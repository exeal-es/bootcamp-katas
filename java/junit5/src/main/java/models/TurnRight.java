package models;

public class TurnRight {
    private final MarsRover marsRover;

    public TurnRight(MarsRover marsRover) {
        this.marsRover = marsRover;
    }

    void turnRight() {
        // get new direction
        int currentDirectionPosition = marsRover.getAvailableDirections().indexOf(marsRover.getDirection());
        if (currentDirectionPosition != 3) {
            marsRover.setDirection(marsRover.getAvailableDirections().charAt(currentDirectionPosition + 1));
        } else {
            marsRover.setDirection(marsRover.getAvailableDirections().charAt(0));
        }
    }
}