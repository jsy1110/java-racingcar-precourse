package racingcar;

import racingcar.view.GameView;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();

        GameView game = appConfig.gameView();
        game.playGame();
    }
}
