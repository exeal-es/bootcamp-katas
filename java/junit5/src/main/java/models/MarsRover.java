package models;

public class MarsRover {
    private final TurnRight turnRight = new TurnRight(this);
    private final TurnLeft turnLeft = new TurnLeft(this);
    private final MoveStraight moveStraight = new MoveStraight(this);
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
                moveStraight.moveStraight();
            } else if (command.isTurnLeft()) {
                turnLeft.turnLeft();
            } else if (command.isTurnRight()) {
                turnRight.turnRight();
            }
        }
    }

    public char getDirection() {
        return direction;
    }

    public String getAvailableDirections() {
        return availableDirections;
    }

    public void setDirection(char direction) {
        this.direction = direction;
    }

    public String[] getObstacles() {
        return obstacles;
    }

    public boolean isObstacleFound() {
        return obstacleFound;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public void setObstacleFound(boolean obstacleFound) {
        this.obstacleFound = obstacleFound;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }
}
