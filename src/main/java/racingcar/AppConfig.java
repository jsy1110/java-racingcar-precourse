package racingcar;

import racingcar.domain.gamerule.GameRule;
import racingcar.domain.gamerule.RacingGameRule;
import racingcar.settings.Settings;
import racingcar.view.GameView;

public class AppConfig {
    public GameView gameView() {
        return new GameView(settings(), gameRule());
    }

    public GameRule gameRule() {
        return new RacingGameRule();
    }

    public Settings settings() {
        return new Settings();
    }
}
