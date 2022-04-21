package racingcar.view;

import racingcar.domain.gamerule.GameRule;
import racingcar.domain.settings.Settings;
import racingcar.domain.circuit.Circuit;

public class GameView implements View {

    private final Settings settings;
    private final GameRule gameRule;

    public GameView(Settings settings, GameRule gameRule) {
        this.settings = settings;
        this.gameRule = gameRule;
    }

    @Override
    public void playGame() {
        Circuit circuit = settings.getCircuit();
        circuit.play(settings.getRound());
        gameRule.getResult(circuit);
    }



}
