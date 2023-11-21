package models;

import java.util.Arrays;

public class MoveStraight {
    private final MarsRover marsRover;

    public MoveStraight(MarsRover marsRover) {
        this.marsRover = marsRover;
    }

    void moveStraight() {
        switch (marsRover.getDirection()) {
            case 'E':
                marsRover.setObstacleFound(Arrays.asList(marsRover.getObstacles()).contains((marsRover.getX() + 1) + ":" + marsRover.getY()));
                // check if rover reached plateau limit or found an obstacle
                marsRover.setX(marsRover.getX() < 9 && !marsRover.isObstacleFound() ? marsRover.getX() + 1 : marsRover.getX());
                break;
            case 'S':
                marsRover.setObstacleFound(Arrays.asList(marsRover.getObstacles()).contains(marsRover.getX() + ":" + (marsRover.getY() + 1)));
                // check if rover reached plateau limit or found an obstacle
                marsRover.setY(marsRover.getY() < 9 && !marsRover.isObstacleFound() ? marsRover.getY() + 1 : marsRover.getY());
                break;
            case 'W':
                marsRover.setObstacleFound(Arrays.asList(marsRover.getObstacles()).contains((marsRover.getX() - 1) + ":" + marsRover.getY()));
                // check if rover reached plateau limit or found an obstacle
                marsRover.setX(marsRover.getX() > 0 && !marsRover.isObstacleFound() ? marsRover.getX() - 1 : marsRover.getX());
                break;
            case 'N':
                marsRover.setObstacleFound(Arrays.asList(marsRover.getObstacles()).contains(marsRover.getX() + ":" + (marsRover.getY() - 1)));
                // check if rover reached plateau limit or found an obstacle
                marsRover.setY(marsRover.getY() > 0 && !marsRover.isObstacleFound() ? marsRover.getY() - 1 : marsRover.getY());
                break;
        }
    }
}