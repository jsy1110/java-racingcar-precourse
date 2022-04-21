package racingcar.domain.gamerule;

import racingcar.domain.circuit.Circuit;

import java.util.List;

public interface GameRule {

    List<String> getResult(Circuit circuit);

}
