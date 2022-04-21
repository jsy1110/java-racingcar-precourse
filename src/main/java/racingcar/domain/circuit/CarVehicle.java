package racingcar.domain.circuit;

public class CarVehicle implements Vehicle {

    private final CarName carName;
    private final CarPosition carPosition;

    public CarVehicle(CarName carName, CarPosition carPosition) {
        this.carName = carName;
        this.carPosition = carPosition;
    }

    @Override
    public void go() {

    }
}
