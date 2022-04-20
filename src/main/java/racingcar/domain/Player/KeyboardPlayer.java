package racingcar.domain.Player;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Vehicle.Vehicle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class KeyboardPlayer implements Player {

    @Override
    public List<String> getCars() {
        String input = Console.readLine().trim();
        String[] cars = input.split(",");
        List<String> names = new ArrayList<>();
        for (String car : cars) {
            names.add(car);
        }
        return names;
    }

    @Override
    public int getNumber() {
        String input = Console.readLine();
        return validateNumber(input);
    }

    private int validateNumber(String input) {
        Integer result = 0;
        try {
            result = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력한 값이 숫자가 아닙니다.");
        }
        return result;
    }
}
