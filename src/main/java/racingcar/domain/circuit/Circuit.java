package racingcar.domain.circuit;

import racingcar.domain.settings.RacingRound;
import racingcar.utils.ExceptionMessage;

import java.util.Set;

public class Circuit {

    private final Set<CarVehicle> cars;
    private final RacingRound round;

    public Circuit(Set<CarVehicle> cars, RacingRound round) {
        validateMaxCar(cars);
        this.cars = cars;
        this.round = round;
    }


    private void validateMaxCar(Set<CarVehicle> cars) {
        if (cars.size() > 1000) {
            throw new IllegalArgumentException(ExceptionMessage.CAR_PARTICIPATION_OVER.getMessage());
        }
    }

}
