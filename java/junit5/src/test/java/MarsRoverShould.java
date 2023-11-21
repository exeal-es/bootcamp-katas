import models.Commands;
import models.MarsRover;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MarsRoverShould {

    @ParameterizedTest
    @CsvSource({"0, 0, E, M, 1:0:E",
            "0, 0, S, M, 0:1:S",
            "1, 0, W, M, 0:0:W",
            "0, 1, N, M, 0:0:N"})
    public void moveOneCellForward(int x, int y, char direction, String commands, String expectedFinalState) {
        MarsRover marsRover = new MarsRover(x, y, direction, new String[]{});
        marsRover.execute(new Commands(commands));
        assertEquals(expectedFinalState, marsRover.getState());
    }

    @ParameterizedTest
    @CsvSource({"0, 0, N, M, 0:0:N",
            "0, 0, W, M, 0:0:W",
            "9, 0, E, M, 9:0:E",
            "0, 9, S, M, 0:9:S"})
    public void wrapAroundTheEdgesOfThePlateau(int x, int y, char direction, String commands, String expectedFinalState) {
        MarsRover marsRover = new MarsRover(x, y, direction, new String[]{});
        marsRover.execute(new Commands(commands));
        assertEquals(expectedFinalState, marsRover.getState());
    }

    @ParameterizedTest
    @CsvSource({"L, 0:0:N",
            "LL, 0:0:W",
            "LLL, 0:0:S",
            "LLLL, 0:0:E",
            "R, 0:0:S",
            "RR, 0:0:W",
            "RRR, 0:0:N",
            "RRRR, 0:0:E"})
    public void rotateLeftAndRight(String commands, String expectedFinalState) {
        MarsRover marsRover = new MarsRover(0, 0, 'E', new String[]{});
        marsRover.execute(new Commands(commands));
        assertEquals(expectedFinalState, marsRover.getState());
    }

    @ParameterizedTest
    @CsvSource({"0, 0, E, MMM, 3:0, O:2:0:E",
            "0, 0, S, MMM, 0:3, O:0:2:S",
            "9, 0, W, MMM, 7:0, O:8:0:W",
            "0, 9, N, MMM, 0:7, O:0:8:N"})
    public void stopAndReportIfAnObstacleIsFound(int x, int y, char direction, String commands, String obstaclePosition, String expectedFinalState) {
        MarsRover marsRover = new MarsRover(x, y, direction, new String[]{obstaclePosition});
        marsRover.execute(new Commands(commands));
        assertEquals(expectedFinalState, marsRover.getState());
    }
}