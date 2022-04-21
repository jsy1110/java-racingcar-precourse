package racingcar.domain.settings;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.circuit.CarName;
import racingcar.domain.circuit.CarPosition;
import racingcar.domain.circuit.CarVehicle;
import racingcar.domain.circuit.Circuit;
import racingcar.utils.GameMessage;

import java.util.HashSet;
import java.util.Set;

public class Settings {

    private Set<CarVehicle> cars = new HashSet<>();
    private RacingRound round;

    public Circuit getCircuit() {

        while (!createCircuit()) ;
        while (!createRound()) ;
        return new Circuit(cars, round);
    }

    private boolean createCircuit() {
        System.out.println(GameMessage.INPUT_CARS_LIST.getMessage());
        try {
            createCars();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    private void createCars() throws IllegalArgumentException {
        InputNames inputNames = new InputNames(Console.readLine().trim());
        for (String name : inputNames.getNames()) {
            CarName carName = new CarName(name);
            CarPosition carPosition = new CarPosition(0);
            cars.add(new CarVehicle(carName, carPosition));
        }
    }

    private boolean createRound() {
        try {
            System.out.println(GameMessage.INPUT_ROUND.getMessage());
            round = new RacingRound(Console.readLine().trim());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }
}
