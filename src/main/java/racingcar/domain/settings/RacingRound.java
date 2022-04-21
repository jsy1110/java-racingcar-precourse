package racingcar.domain.settings;

public class RacingRound {

    private final int round;

    public RacingRound(String input) throws IllegalArgumentException {
        int round = Integer.parseUnsignedInt(input);

        if (round > 10000) {
            throw new IllegalArgumentException("[ERROR] 최대 경기 라운드는 10000 입니다.");
        }

        if (round < 1) {
            throw new IllegalArgumentException("[ERROR] 최소 1경기 이상 입력해야 합니다.");
        }
        this.round = round;
    }
}
