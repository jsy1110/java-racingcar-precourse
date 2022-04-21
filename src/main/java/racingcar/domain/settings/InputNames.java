package racingcar.domain.settings;

import racingcar.utils.ExceptionMessage;

import java.util.ArrayList;
import java.util.List;

public class InputNames {
    private List<String> names = new ArrayList<>();

    public InputNames(String input) {
        String[] cars = input.split(",");
        for (String car : cars) {
            names.add(car);
        }
        if ( names.size() != names.stream().distinct().count() ) {
            throw new IllegalArgumentException(ExceptionMessage.CAR_DUPLICATE_PARTICIPATION.getMessage());
        }
    }

    public List<String> getNames() {
        return names;
    }
}
