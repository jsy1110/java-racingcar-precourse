package racingcar.utils;

public enum ExceptionMessage {
    CAR_NAME_LENGTH_TOO_LONG("[ERROR] 자동차 이름이 5자를 넘었습니다."),
    CAR_POSITION_WRONG("[ERROR] 자동차의 위치는 0보다 커야 합니다."),
    CAR_PARTICIPATION_OVER("[ERROR] 참여가능한 최대 자동차의 숫자는 1000개 입니다."),
    CAR_DUPLICATE_PARTICIPATION("[ERROR] 중복된 자동차 이름이 있습니다."),

    MAXIMUM_ROUND_OVER("[ERROR] 최대 경기 라운드는 10000입니다."),
    MINIMUM_ONE_GAME("[ERROR] 최소 1경기 이상 입력해야 합니다."),
    NEGATIVE_ROUND_NUMBER("[ERROR] 경기수는 1~10000 사이의 숫자를 입력해주세요."),

    CAR_STEP_NEGATIVE("[ERROR] 차 전진에 대한 값은 음수가 될 수 없습니다.");

    private String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
