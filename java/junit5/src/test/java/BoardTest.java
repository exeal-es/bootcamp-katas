
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BoardTest {

    @Test
    public void shouldReturnIsNotExploded() {
        //given
        Board board = new Board(1,1);

        //when
        boolean hasExploded = board.play(0,0);

        //then
        Assertions.assertFalse(hasExploded);
    }


}
