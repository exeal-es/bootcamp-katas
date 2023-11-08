import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class BoardTest {

    @Test
    public void shouldReturnPosition() {
        //given
        Board board = new Board(1,1);

        //when
        boolean hasExploded = board.play(0,0);

        //then
        Assert.assertFalse(hasExploded);
    }
}
