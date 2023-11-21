package models;

import java.util.HashMap;

public class MarsRover {

  private int x;
  private int y;
  private char direction;
  private final String availableDirections = "NESW";
  private final Obstacles obstacles;
  private boolean obstacleFound;

  public MarsRover(int x, int y, char direction, String[] obstacles) {
    this.x = x;
    this.y = y;
    this.direction = direction;
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

  boolean containsObstacle(int x, int y) {
    return obstacles.collidePosition(x, y);
  }

  void moveEast() {
    int newX = x + 1;
    obstacleFound = containsObstacle(newX, y);
    // check if rover reached plateau limit or found an obstacle
    x = x < 9 && !obstacleFound ? newX : x;
  }

  void moveSouth() {
    int newY = y + 1;
    obstacleFound = containsObstacle(x, newY);
    // check if rover reached plateau limit or found an obstacle
    y = y < 9 && !obstacleFound ? newY : y;
  }

  void moveWest() {
    int newX = x - 1;
    obstacleFound = containsObstacle(newX, y);
    // check if rover reached plateau limit or found an obstacle
    x = x > 0 && !obstacleFound ? newX : x;
  }

  void moveNorth() {
    int newY = y - 1;
    obstacleFound = containsObstacle(x, newY);
    // check if rover reached plateau limit or found an obstacle
    y = y > 0 && !obstacleFound ? newY : y;
  }
}
