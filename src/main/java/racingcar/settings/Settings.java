package racingcar.settings;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.circuit.*;
import racingcar.domain.circuit.vehicle.CarName;
import racingcar.domain.circuit.vehicle.CarPosition;
import racingcar.domain.circuit.vehicle.CarVehicle;
import racingcar.utils.GameMessage;

import java.util.ArrayList;
import java.util.List;

import static racingcar.utils.PrintUtils.printMessageLine;

public class Settings {

    private RacingRound round;
    private List<CarVehicle> cars = new ArrayList<>();

    public Circuit makeGame() {
        createCircuit();
        createRound();
        return new Circuit(cars);
    }

    public List<CarVehicle> getCars() {
        return cars;
    }

    public RacingRound getRound() {
        return round;
    }

    private void createCircuit() {
        printMessageLine(GameMessage.INPUT_CARS_LIST.getMessage());
        try {
            createCars();
        } catch (IllegalArgumentException e) {
            printMessageLine(e.getMessage());
            createCircuit();
        }
    }

    private void createCars() throws IllegalArgumentException {
        InputNames inputNames = new InputNames(Console.readLine().replaceAll(" ",""));
        for (String name : inputNames.getNames()) {
            CarName carName = new CarName(name);
            CarPosition carPosition = new CarPosition(0);
            cars.add(new CarVehicle(carName, carPosition));
        }
    }

    private void createRound() {
        try {
            printMessageLine(GameMessage.INPUT_ROUND.getMessage());
            round = new RacingRound(Console.readLine().trim());
        } catch (IllegalArgumentException e) {
            printMessageLine(e.getMessage());
            createRound();
        }
    }

}
