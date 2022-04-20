package racingcar;

import racingcar.domain.GameRule.GameRule;
import racingcar.domain.GameRule.RacingGameRule;
import racingcar.domain.Player.KeyboardPlayer;
import racingcar.domain.Player.Player;
import racingcar.domain.Settings.RacingSettings;
import racingcar.domain.Settings.Settings;
import racingcar.domain.Vehicle.CarVehicle;
import racingcar.domain.Vehicle.Vehicle;
import racingcar.view.GameView;

public class AppConfig {
    public GameView gameView() {
        return new GameView(player(), gameRule(), settings());
    }

    public GameRule gameRule() {
        return new RacingGameRule();
    }

    public Settings settings() {
        return new RacingSettings();
    }

    public Player player() {
        return new KeyboardPlayer();
    }
}
