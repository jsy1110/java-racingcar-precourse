package racingcar.settings;

import org.junit.jupiter.api.Test;
import racingcar.domain.circuit.CarName;

import static org.junit.jupiter.api.Assertions.*;

class InputNamesTest {

    @Test
    void 중복이름_발생_ERROR() {

        assertThrows(IllegalArgumentException.class, () -> {
            InputNames carName = new InputNames("fer,benz,benz");
        });
    }

}