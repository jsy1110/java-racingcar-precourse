package racingcar.domain.circuit;

import racingcar.utils.ExceptionMessage;

public class CarPosition {
    private final int position;

    public CarPosition(int position) {
        validate(position);
        this.position = position;
    }

    private void validate(int position) {
        if (position < 0) {
            throw new IllegalArgumentException(ExceptionMessage.CAR_POSITION_WRONG.getMessage());
        }
    }

}
