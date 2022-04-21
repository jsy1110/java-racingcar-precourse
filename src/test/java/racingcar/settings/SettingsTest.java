package racingcar.settings;

import com.sun.deploy.util.StringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.AppConfig;
import racingcar.Application;
import racingcar.domain.circuit.CarVehicle;
import racingcar.domain.circuit.RacingRound;
import racingcar.settings.Settings;
import racingcar.utils.ExceptionMessage;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import camp.nextstep.edu.missionutils.test.NsTest;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class SettingsTest extends NsTest{

    private Settings settings;

    @BeforeEach
    void beforeEach() {
        AppConfig appConfig = new AppConfig();
        settings = appConfig.settings();
    }

    @Test
    @DisplayName("자동차를 입력받아 입력값 체크를 한다.")
    void 서킷_생성_OK() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // given
        userInputTest("Fer, Mer, HAS, RedBu");

        Method method = settings.getClass().getDeclaredMethod("createCircuit");
        method.setAccessible(true);

        // when
        method.invoke(settings);

        // then
        List<CarVehicle> cars = settings.getCars();
        List<String> names = new ArrayList<>();
        cars.stream().forEach(carVehicle -> names.add(carVehicle.getCarName().getCarName()));
        assertThat(StringUtils.join(names,",")).isEqualTo("Fer,Mer,HAS,RedBu");
    }

    @Test
    @DisplayName("자동차 이름 오류 발생")
    void 서킷_생성_ERROR() {
        assertSimpleTest(
                () -> {
                    runException("Ferrari, Mer, HAS, RedBull");
                    assertThat(output()).contains(ExceptionMessage.CAR_NAME_LENGTH_TOO_LONG.getMessage());
                }
        );
    }

    @Test
    @DisplayName("경기수를 입력 받는다.")
    void 경기수입력_OK() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // given
        userInputTest("5");

        Method method = settings.getClass().getDeclaredMethod("createRound");
        method.setAccessible(true);

        // when
        method.invoke(settings);

        // then
        RacingRound round = settings.getRound();
        assertThat(round.getRound()).isEqualTo(5);
    }

    @Test
    @DisplayName("경기수가 음수이면 에러를 발생시킨다.")
    void 경기수입력_음수_ERROR() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        assertSimpleTest(
                () -> {
                    runException("Fer, Mer, HAS, RedBu", "-1");
                    assertThat(output()).contains(ExceptionMessage.NEGATIVE_ROUND_NUMBER.getMessage());
                }
        );
    }

    @Test
    @DisplayName("최대 경기수 이상 입력시 에러를 발생시킨다.")
    void 경기수입력_최대값_OVER_ERROR() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        assertSimpleTest(
                () -> {
                    runException("Fer, Mer, HAS, RedBu", "10001");
                    assertThat(output()).contains(ExceptionMessage.MAXIMUM_ROUND_OVER.getMessage());
                }
        );
    }

    @Test
    @DisplayName("최소 경기수 이하 입력시 에러를 발생시킨다.")
    void 경기수입력_최소값_OVER_ERROR() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        assertSimpleTest(
                () -> {
                    runException("Fer, Mer, HAS, RedBu", "0");
                    assertThat(output()).contains(ExceptionMessage.MINIMUM_ONE_GAME.getMessage());
                }
        );
    }

    private void userInputTest(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Scanner sc = new Scanner(System.in);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}