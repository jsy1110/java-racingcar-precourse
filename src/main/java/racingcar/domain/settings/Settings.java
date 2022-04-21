package racingcar.domain.settings;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.circuit.CarName;
import racingcar.domain.circuit.CarPosition;
import racingcar.domain.circuit.CarVehicle;
import racingcar.domain.circuit.Circuit;
import racingcar.utils.GameMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Settings {

    private RacingRound round;
    private List<CarVehicle> cars = new ArrayList<>();

    public Circuit getCircuit() {

        createCircuit();
        createRound();
        return new Circuit(cars);
    }

    public RacingRound getRound() {
        return round;
    }


    private void createCircuit() {
        System.out.println(GameMessage.INPUT_CARS_LIST.getMessage());
        try {
            createCars();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            createCircuit();
        }
    }

    private void createCars() throws IllegalArgumentException {
        InputNames inputNames = new InputNames(Console.readLine().trim());
        for (String name : inputNames.getNames()) {
            CarName carName = new CarName(name);
            CarPosition carPosition = new CarPosition(0);
            cars.add(new CarVehicle(carName, carPosition));
        }
    }

    private void createRound() {
        try {
            System.out.println(GameMessage.INPUT_ROUND.getMessage());
            round = new RacingRound(Console.readLine().trim());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            createRound();
        }
    }

}
