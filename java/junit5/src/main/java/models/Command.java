package models;

public enum Command {

    L, M, R;

    public static Command parse(String s) {
        if(s.equals("L")) {
            return L;
        };
        if(s.equals("M")) {
            return M;
        };

        return R;
    }

    public boolean isMoveStraight() {
        return this == M;
    }

    public boolean isTurnLeft() {
        return this == L;
    }

    public boolean isTurnRight() {
        return this == R;
    }
}
