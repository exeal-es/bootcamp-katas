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

}
