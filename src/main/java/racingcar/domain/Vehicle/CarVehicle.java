package racingcar.domain.Vehicle;

import java.util.List;

public class CarVehicle implements Vehicle {

    private final List<String> carNames;

    public CarVehicle(List<String> carNames) {
        carNameLength(carNames);
        this.carNames = carNames;
    }

    private void carNameLength(List<String> carNames) {
        for (String carName : carNames) {
            checkLength(carName);
        }
    }

    private void checkLength(String name) {
        if (name.length() > 5)  {
            throw new IllegalArgumentException("[ERROR] 자동차 중 5자 이상의 이름이 있습니다.");
        }
    }

    @Override
    public void go() {

    }
}
