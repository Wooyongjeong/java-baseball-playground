package baseball;

public enum GameCommand {
    CONTINUE("1"),
    END("2");

    private final String command;

    GameCommand(String command) {
        this.command = command;
    }

    public static GameCommand from(String command) {
        if (CONTINUE.command.equals(command)) {
            return CONTINUE;
        }
        if (END.command.equals(command)) {
            return END;
        }
        throw new IllegalArgumentException("1 또는 2의 게임 커맨드가 아닙니다.");
    }

    public boolean isEnd() {
        return this == END;
    }
}
