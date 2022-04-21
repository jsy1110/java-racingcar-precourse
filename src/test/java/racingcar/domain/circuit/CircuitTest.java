package racingcar.domain.circuit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CircuitTest {

    @Test
    @DisplayName("경기 회수는 1000경기 이하여야 한다.")
    void 경기회수_OK() {
        //given
        List<CarVehicle> carVehicleList = mock(ArrayList.class);
        when(carVehicleList.size()).thenReturn(100);

        //when
        Circuit circuit = new Circuit(carVehicleList);

        //then
    }

    @Test
    @DisplayName("경기 회수가 1000경기 이상일 경우 오류가 발생한다.")
    void 경기회수_ERROR() {
        //given
        List<CarVehicle> carVehicleList = mock(ArrayList.class);
        when(carVehicleList.size()).thenReturn(1001);

        //when
        //then
        assertThrows(IllegalArgumentException.class, () -> {

            Circuit circuit = new Circuit(carVehicleList);
        });
    }
}