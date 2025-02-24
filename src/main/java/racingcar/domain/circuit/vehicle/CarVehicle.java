package racingcar.domain.circuit.vehicle;

import camp.nextstep.edu.missionutils.Randoms;

import static racingcar.utils.PrintUtils.*;

public class CarVehicle implements Vehicle, Comparable<CarVehicle> {

    private final CarName carName;
    private final CarPosition carPosition;

    public CarVehicle(CarName carName, CarPosition carPosition) {
        this.carName = carName;
        this.carPosition = carPosition;
    }

    public CarName getCarName() {
        return carName;
    }

    public CarPosition getCarPosition() {
        return carPosition;
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
        return carPosition.getPosition() - car.carPosition.getPosition();
    }

    public void showPosition() {
        printMessage(carName.getCarName() + " : ");
        for (int i = 0; i < carPosition.getPosition(); i++) {
            printMessage("-");
        }
        changeLine();
    }
}
