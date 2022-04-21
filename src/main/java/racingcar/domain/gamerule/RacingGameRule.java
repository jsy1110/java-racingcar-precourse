package racingcar.domain.gamerule;

import racingcar.domain.circuit.CarVehicle;
import racingcar.domain.circuit.Circuit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingGameRule implements GameRule {

    @Override
    public List<String> getResult(Circuit circuit) {
        List<String> champions = new ArrayList<>();
        CarVehicle maxCar = Collections.max(circuit.getCars());

        circuit.getCars().forEach(carVehicle -> {
            getChampion(champions, maxCar, carVehicle);
        });

        return champions;
    }

    private void getChampion(List<String> champions, CarVehicle maxCar, CarVehicle carVehicle) {
        if (carVehicle.compareTo(maxCar) == 0) {
            champions.add(carVehicle.getCarName().getCarName());
        }
    }
}
