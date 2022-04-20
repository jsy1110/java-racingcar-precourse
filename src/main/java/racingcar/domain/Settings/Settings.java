package racingcar.domain.Settings;

import racingcar.domain.Player.Player;
import racingcar.domain.Vehicle.Vehicle;

import java.util.List;

public interface Settings {

    List<Vehicle> create(Player player);

}
