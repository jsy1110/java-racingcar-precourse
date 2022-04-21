package racingcar.domain.circuit;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.circuit.vehicle.CarName;

import static org.junit.jupiter.api.Assertions.*;

class CarNameTest {

    @Test
    @DisplayName("정상적인 자동차 이름 입력")
    void 자동차_이름_길이_OK() {
        //given

        //when
        CarName carName = new CarName("Fer");

        //then
        Assertions.assertThat(carName.getCarName()).isEqualTo("Fer");

    }
    @Test
    @DisplayName("자동차 이름의 길이가 5자리 이상이면 오류가 발생한다.")
    void 자동차_이름_길이_ERROR() {
        //given

        //when
        //then
        assertThrows(IllegalArgumentException.class, () -> {
            CarName carName = new CarName("Ferrari");
        });
    }
}