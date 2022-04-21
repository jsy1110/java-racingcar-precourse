package racingcar.domain.circuit;

import racingcar.utils.ExceptionMessage;

public class CarName {
    private final String carName;

    public CarName(String carName) {
        checkLength(carName);
        this.carName = carName;
    }

    public String getCarName() {
        return carName;
    }

    private void checkLength(String name) {
        if (name.length() > 5)  {
            throw new IllegalArgumentException(ExceptionMessage.CAR_NAME_LENGTH_TOO_LONG.getMessage());
        }
    }
}
