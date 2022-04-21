package racingcar.domain.circuit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.circuit.vehicle.CarPosition;

import static org.junit.jupiter.api.Assertions.*;

class CarPositionTest {

    @Test
    @DisplayName("자동차 위치는 0 이상이여야 한다.")
    void 자동차_위치_ERROR() {
        //given

        //when
        //then
        assertThrows(IllegalArgumentException.class, () -> {
            CarPosition carPosition = new CarPosition(-1);
        });
    }
}