package baseball;

import java.util.stream.IntStream;

public class Result {
    private int ball;
    private int strike;

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }

    public void compare(String[] playerNumbers, String[] computerNumbers) {
        this.strike = compareStrike(playerNumbers, computerNumbers);
        this.ball = compareBall(playerNumbers, computerNumbers);
    }

    public int compareStrike(String[] playerNumbers, String[] computerNumbers) {
        int strike = 0;
        for (int i = 0; i < playerNumbers.length; i++) {
            String player = playerNumbers[i];
            String computer = computerNumbers[i];
            strike += isStrike(player, computer);
        }
        return strike;
    }

    public int compareBall(String[] playerNumbers, String[] computerNumbers) {
        int ball = 0;
        for (int i = 0; i < playerNumbers.length; i++) {
            String player = playerNumbers[i];
            ball += isBall(player, i, computerNumbers);
        }
        return ball;
    }

    public int isStrike(String player, String computer) {
        if (player.equals(computer)) {
            return 1;
        }
        return 0;
    }

    public int isBall(String player, int index, String[] computerNumbers) {
        if (IntStream.range(0, computerNumbers.length)
                .filter(i -> i != index && computerNumbers[i].equals(player))
                .count() > 0) {
            return 1;
        }
        return 0;
    }
}
