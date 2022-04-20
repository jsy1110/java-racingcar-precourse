# 자동차 레이싱 게임 (우테캠 PRO 4기 프리코스 2주차)
## 개발 환경
- IDE: IntelliJ IDEA (Ultimate Edition)
- OS: Window 10 Education
- Language : JAVA8
- Build : Gradle
- Test : Junit5

## 기능 요구 사항
주어진 횟수 동안 N대의 자동차는 전진 또는 멈출 수 있다.

1. 사용자는 각 자동차의 이름을 부여한다. 자동차의 이름은 자동차 출력에 쓰인다.
자동차의 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
2. 사용자는 몇 번의 이동을 할 것인지 입력한다.
3. 전진하는 조건은 0~9 사이의 랜덤값을 구한 후 1~3일 경우 멈추고, 4~9일 경우 전진한다.
4. 사용자가 입력한 횟수의 이동이 종료되면 우승자를 결정하고 출력한다.
단, 우승자가 한 명 이상일 경우 쉼표(,)로 구분해 출력한다.
5. 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException를 발생시키고,
[ERROR] 로 시작하는 에러메시지를 출력 후 그 부분부터 다시 입력 받는다.

## MVC 모델링
1주차 과제의 경우 `Player, Opponent, GameRule`로 도메인 을 나눴다.
2주차 과제도 같은 도메인을 그대로 사용하고 몇가지 역할을 추가한다.
- `Settings` : 게임 세팅
- `Vehicle` : 게임에 사용될 경주마
* 1주차 과제 시 도메인을 Interface로 만들었기 때문에 구현체만 교체해서 쓸 수 있다.
(다만 이전과제에서 Controller 추상화가 되지 않아 View, Controller는 새로 만든다.)

1. View, Controller 역할은 GameView 에서 한다.
2. 도메인 역할은 `Player, Opponent, GameRule, Vehicle, Settings` 4가지를 사용한다.
- 각각의 도메인은 Interface로 만들어 확장에 열려있다. (OCP)
- AppConfig를 통해 객체간 의존성을 주입한다. (DI)
3. 각 도메인별 역할
- Player : 자동차의 이름 입력과 이동횟수 입력
- Vehicle : Player가 입력한 값에 따라 정의된 자동차 객체
- Settings : 게임에 필요한 환경 세팅
- GameRule : 최종 Vehicle의 전진 거리를 비교하여 결과 출력

## 구현 기능
### Main
- AppConfig를 통해 객체를 생성하고 의존성을 주입한다. (Singleton 패턴)
- `GameView.gameplay()` 를 통해 게임을 시작하고, 게임이 끝나면 종료한다.

### View
- 생성자를 통해 객체 생성 시점에 필요한 객체를 주입 받는다. (Player, Opponent, GameRule, Vehicle)
- `playGame()` : 전체 게임의 흐름을 제어한다.
- 게임 흐름 : Opponent 값 생성 -> (Player 값 입력 -> 결과 확인) 반복 -> 재경기 or 프로그램 종료

### Config
- AppConfig 클래스를 통해 각 객체 별 의존성 주입 관계를 정의한다.

### 도메인
1. Player (Interface) -> RacingPlayer
- `getCars()` : 자동차들의 이름을 입력 받는다.
- `getNumber()` : 이동할 횟수를 입력 받는다.
- `validateCars(String input)` : 플레이어의 입력값을 검증한다. 입력값에 오류가 있는 경우 IllegalArgumentException 발생 후 종료된다.
- `validateNumber(String input)` : 플레이어의 입력값을 검증한다. 입력값에 오류가 있는 경우 IllegalArgumentException 발생 후 종료된다.

2. Settings (Interface) -> RacingSetting
- 출발선에 들어갈 경주용 자동차들의 초기 세팅값을 결정한다.
- `create(String cars, String number)` : 자동차 입력과 횟수값을 이용해서 Vehicle(RacingCar)를 만든다.
> 만약 사전 Settings 조건이 변경되더라도 Settings 인터페이스를 상속 받는 MousePlayer 클래스를 새롭게 정의하고,
> AppConfig에서 주입 클래스만 수정하여 변경할 수 있다. (View 수정X)

3. Vehicle (CarVehicle)
- Player가 입력한 자동차의 이름과 이동횟수를 이용하여 만들어진 경주용 객체
- `Go()` : 해당 Vehicle을 1회 이동시킨다. 랜덤값에 따라 전진 혹은 멈춤이 결정된다.

4. GmaeRule (Interface) -> RacingGameRule
- Vehicle 들의 최종위치를 확인하고, 1등을 결정한다.
- `String judge(ArrayList<Vehicle> vehicles)` : Vehicle의 최종 위치를 확인하여 1등을 결정한다.
> 1주차 과제에서는 BaseballGameRule을 구현체로 사용했지만 2주차에서는 RacingGameRule을 구현체로 사용한다.
> AppConfig에서 주입 클래스만 수정하여 변경할 수 있다. (View 수정X)

## Test
TBD

