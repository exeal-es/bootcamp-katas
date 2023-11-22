package models;

import java.util.HashMap;

public class MarsRover {

  private int x;
  private int y;
  private char direction;
  private Direction currentDirection;
  private final String availableDirections = "NESW";
  private final Obstacles obstacles;
  private boolean obstacleFound;

  public MarsRover(int x, int y, char direction, String[] obstacles) {
    this.x = x;
    this.y = y;
    this.direction = direction;
    this.currentDirection = Direction.parse(direction);
    this.obstacles = new Obstacles(obstacles);
  }

  public String getState() {
    return !obstacleFound ? x + ":" + y + ":" + direction : "O:" + x + ":" + y + ":" + direction;
  }

  public void execute(Commands commands) {
    for (Command command : commands.getCommands()) {
      getCommandAction(command).execute();
    }
  }

  private CommandAction getCommandAction(Command command) {
    HashMap<Command, CommandAction> commandMap = new HashMap<>();

    commandMap.put(Command.M, new MoveStraight(this));
    commandMap.put(Command.L, new TurnLeft(this));
    commandMap.put(Command.R, new TurnRight(this));

    return commandMap.get(command);
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

  public void move() {
    move(currentDirection.moveX(x), currentDirection.moveY(y));
  }

  private void move(final int x, final int y) {
    if (containsObstacle(x, y)) {
      obstacleFound = true;
      return;
    }
    if (isWithinLimits(x, y)) {
      return;
    }
    this.x = x;
    this.y = y;
  }

  private static boolean isWithinLimits(int x, int y) {
    return x < 0 || x > 9 || y < 0 || y > 9;
  }

  private boolean containsObstacle(int x, int y) {
    return obstacles.collidePosition(x, y);
  }
}
