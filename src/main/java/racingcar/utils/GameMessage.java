package racingcar.utils;

public enum GameMessage {
    INPUT_CARS_LIST("경주에 참여할 자동차의 이름을 입력해주세요. 자동차의 이름은 최대 5글자 입니다. \n" +
                    "자동차의 이름 구분은 콤마(,)로 구분합니다."),
    INPUT_ROUND("경주를 진행할 경기수를 입력해주세요. 경기는 최소 1경기, 최대 10,000경기 진행할 수 있습니다."),
    THE_CHAMPION("최종 우승자는 "),
    IS_WHO(" 입니다.");

    private String message;

    GameMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
