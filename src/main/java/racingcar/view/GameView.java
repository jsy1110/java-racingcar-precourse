package racingcar.view;

import racingcar.domain.GameRule.GameRule;
import racingcar.domain.Player.Player;
import racingcar.domain.Settings.Settings;
import racingcar.domain.Vehicle.CarVehicle;
import racingcar.domain.Vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class GameView implements View {

    private final Player player;
    private final GameRule gameRule;
    private final Settings settings;

    private Integer iteration;

    public GameView(Player player, GameRule gameRule, Settings settings) {
        this.player = player;
        this.gameRule = gameRule;
        this.settings = settings;
    }

    @Override
    public void playGame() {
        CarVehicle cars = getCars();
        int iter = getNumber();
    }

    private CarVehicle getCars() {
        try {
            return new CarVehicle(player.getCars());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return new CarVehicle(player.getCars());
        }
    }

    private int getNumber() {
        try {
            return player.getNumber();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return player.getNumber();
        }
    }
}
