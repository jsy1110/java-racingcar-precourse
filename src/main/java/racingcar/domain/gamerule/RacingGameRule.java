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
        circuit.getCars().stream()
                .filter(carVehicle -> carVehicle.compareTo(maxCar) == 0)
                .forEach(carVehicle -> champions.add(carVehicle.getCarName().getCarName()));

        return champions;
    }
}
