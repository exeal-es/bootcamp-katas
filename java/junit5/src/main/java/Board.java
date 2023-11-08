public class Board {


    private boolean mine;

    public Board(int x, int y) {

    }

    public boolean play(int x, int y)
    {
        return mine;
    }

    public void placeMine(int x, int y) {
        mine = true;
    }
}

