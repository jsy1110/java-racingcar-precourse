package racingcar.domain.circuit;

import racingcar.utils.ExceptionMessage;

public class RacingRound {

    private final int round;

    public RacingRound(String input) throws IllegalArgumentException {
        try {
            round = Integer.parseUnsignedInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.NEGATIVE_ROUND_NUMBER.getMessage());
        }

        if (round > 10000) {
            throw new IllegalArgumentException(ExceptionMessage.MAXIMUM_ROUND_OVER.getMessage());
        }

        if (round < 1) {
            throw new IllegalArgumentException(ExceptionMessage.MINIMUM_ONE_GAME.getMessage());
        }
    }

    public int getRound() {
        return round;
    }
}
