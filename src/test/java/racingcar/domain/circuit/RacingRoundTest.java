package racingcar.domain.circuit;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RacingRoundTest {

    @Test
    @DisplayName("정상적인 경기수 입력")
    void 경기수_OK() {
        //given

        //when
        RacingRound racingRound = new RacingRound("10");

        //then
        Assertions.assertThat(racingRound.getRound()).isEqualTo(10);

    }

    @Test
    @DisplayName("경기수가 10000경기 이상일때 오류 발생")
    void 경기수_OVER_ERROR() {
        assertThrows(IllegalArgumentException.class, () -> {
            RacingRound racingRound = new RacingRound("10001");
        });
    }

    @Test
    @DisplayName("경기수가 1경기 미만일때 오류 발생")
    void 경기수_1경기_미만_ERROR() {
        assertThrows(IllegalArgumentException.class, () -> {
            RacingRound racingRound = new RacingRound("0");
        });
    }

    @Test
    @DisplayName("경기수가 숫자가 아닐때")
    void 경기수_숫자아님_ERROR() {
        assertThrows(IllegalArgumentException.class, () -> {
            RacingRound racingRound = new RacingRound("다섯경기");
        });
    }
}