package models;

import models.Command;
import models.Commands;

import java.util.Arrays;

public class MarsRover {
    private int x;
    private int y;
    private char direction;
    private final String availableDirections = "NESW";
    private final String[] obstacles;
    private boolean obstacleFound;

    public MarsRover(int x, int y, char direction, String[] obstacles) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.obstacles = obstacles;
    }

    public String getState() {
        return !obstacleFound ? x + ":" + y + ":" + direction : "O:" + x + ":" + y + ":" + direction;
    }

    public void execute(Commands commands) {
        for (Command command : commands.getCommands()) {
            if (command.isMoveStraight()) {
                moveStraight();
            } else if (command.isTurnLeft()) {
                turnLeft();
            } else if (command.isTurnRight()) {
                turnRight();
            }
        }
    }

    private void turnRight() {
        // get new direction
        int currentDirectionPosition = availableDirections.indexOf(direction);
        if (currentDirectionPosition != 3) {
            direction = availableDirections.charAt(currentDirectionPosition + 1);
        } else {
            direction = availableDirections.charAt(0);
        }
    }

    private void turnLeft() {
        // get new direction
        int currentDirectionPosition = availableDirections.indexOf(direction);
        if (currentDirectionPosition != 0) {
            direction = availableDirections.charAt(currentDirectionPosition - 1);
        } else {
            direction = availableDirections.charAt(3);
        }
    }

    private void moveStraight() {
        switch (direction) {
            case 'E':
                obstacleFound = Arrays.asList(obstacles).contains((x + 1) + ":" + y);
                // check if rover reached plateau limit or found an obstacle
                x = x < 9 && !obstacleFound ? x + 1 : x;
                break;
            case 'S':
                obstacleFound = Arrays.asList(obstacles).contains(x + ":" + (y + 1));
                // check if rover reached plateau limit or found an obstacle
                y = y < 9 && !obstacleFound ? y + 1 : y;
                break;
            case 'W':
                obstacleFound = Arrays.asList(obstacles).contains((x - 1) + ":" + y);
                // check if rover reached plateau limit or found an obstacle
                x = x > 0 && !obstacleFound ? x - 1 : x;
                break;
            case 'N':
                obstacleFound = Arrays.asList(obstacles).contains(x + ":" + (y - 1));
                // check if rover reached plateau limit or found an obstacle
                y = y > 0 && !obstacleFound ? y - 1 : y;
                break;
        }
    }

}
