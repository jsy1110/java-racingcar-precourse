package racingcar.view;


import com.sun.deploy.util.StringUtils;
import racingcar.domain.gamerule.GameRule;
import racingcar.settings.Settings;
import racingcar.domain.circuit.Circuit;
import racingcar.utils.GameMessage;

import java.util.List;

import static racingcar.utils.PrintUtils.printMessage;

public class GameView implements View {

    private final Settings settings;
    private final GameRule gameRule;

    public GameView(Settings settings, GameRule gameRule) {
        this.settings = settings;
        this.gameRule = gameRule;
    }

    @Override
    public void playGame() {
        Circuit circuit = settings.makeGame();
        circuit.play(settings.getRound());
        List<String> champions = gameRule.getResult(circuit);
        showChampion(champions);
    }

    private void showChampion(List<String> champions) {
        printMessage(GameMessage.THE_CHAMPION.getMessage() +
                StringUtils.join(champions,",") +
                GameMessage.IS_WHO.getMessage());
    }

}
