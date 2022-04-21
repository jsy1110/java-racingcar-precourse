package racingcar.domain.circuit;

import camp.nextstep.edu.missionutils.Randoms;

public class CarVehicle implements Vehicle, Comparable<CarVehicle> {

    private final CarName carName;
    private final CarPosition carPosition;

    public CarVehicle(CarName carName, CarPosition carPosition) {
        this.carName = carName;
        this.carPosition = carPosition;
    }

    @Override
    public void go() {
        int random = Randoms.pickNumberInRange(0, 9);
        if (random >= 4) {
            carPosition.forward(1);
        }
    }

    @Override
    public int compareTo(CarVehicle car) {
        if (this.carPosition.getPosition() < car.carPosition.getPosition()) {
            return 1;
        }
        if (this.carPosition.getPosition() == car.carPosition.getPosition()) {
            return 0;
        }
        if (this.carPosition.getPosition() > car.carPosition.getPosition()) {
            return -1;
        }
        throw new UnsupportedOperationException();
    }
}
