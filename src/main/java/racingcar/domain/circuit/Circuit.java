package racingcar.domain.circuit;

import racingcar.domain.settings.RacingRound;
import racingcar.utils.ExceptionMessage;

import java.util.Set;

public class Circuit {

    private final Set<CarVehicle> cars;

    public Circuit(Set<CarVehicle> cars) {
        validateMaxCar(cars);
        this.cars = cars;
    }

    private void validateMaxCar(Set<CarVehicle> cars) {
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
        cars.stream().forEach(carVehicle -> {
            carVehicle.go();
        });
    }

//    public ArrayList<String> getChampion() {
//
//    }
}
