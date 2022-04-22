package racingcar.domain.circuit;

import racingcar.domain.circuit.vehicle.CarVehicle;
import racingcar.utils.ExceptionMessage;

import java.util.List;

import static racingcar.utils.PrintUtils.changeLine;

public class Circuit {

    private final List<CarVehicle> cars;

    public Circuit(List<CarVehicle> cars) {
        validateMaxCar(cars);
        this.cars = cars;
    }

    public List<CarVehicle> getCars() {
        return cars;
    }

    private void validateMaxCar(List<CarVehicle> cars) {
        if (cars.size() > 1000) {
            throw new IllegalArgumentException(ExceptionMessage.CAR_PARTICIPATION_OVER.getMessage());
        }
    }

    public void play(RacingRound racingRound) {
        int round = racingRound.getRound();
        for(int i = 0; i < round; i++) {
            playOneRound();
        }
    }

    public void playOneRound() {
        cars.forEach(carVehicle -> {
            carVehicle.go();
            carVehicle.showPosition();
        });

        changeLine();
    }

}
