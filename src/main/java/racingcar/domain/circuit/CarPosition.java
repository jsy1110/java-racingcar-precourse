package racingcar.domain.circuit;

import racingcar.utils.ExceptionMessage;

public class CarPosition {
    private int position;

    public CarPosition(int position) {
        validate(position);
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    private void validate(int position) {
        if (position < 0) {
            throw new IllegalArgumentException(ExceptionMessage.CAR_POSITION_WRONG.getMessage());
        }
    }

    public void forward(int step) {
        if (step < 0) {
            throw new IllegalArgumentException(ExceptionMessage.CAR_POSITION_WRONG.getMessage());
        }
        position += step;
    }

}
