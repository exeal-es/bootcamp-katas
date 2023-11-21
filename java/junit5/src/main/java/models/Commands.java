package models;

import java.util.Objects;

public final class Commands {
    private final String commands;

    public Commands(String commands) {
        this.commands = commands;
    }

    public String commands() {
        return commands;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Commands) obj;
        return Objects.equals(this.commands, that.commands);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commands);
    }

    @Override
    public String toString() {
        return "Commands[" +
                "commands=" + commands + ']';
    }

}