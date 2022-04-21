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
3. 전진하는 조건은 0 ~ 9 사이의 랜덤값을 구한 후 1 ~ 3일 경우 멈추고, 4~9일 경우 전진한다.
4. 사용자가 입력한 횟수의 이동이 종료되면 우승자를 결정하고 출력한다.
단, 우승자가 한 명 이상일 경우 쉼표(,)로 구분해 출력한다.
5. 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException를 발생시키고,
[ERROR] 로 시작하는 에러메시지를 출력 후 그 부분부터 다시 입력 받는다.

## MVC 모델링

1. View, Controller 역할은 GameView 에서 한다.
2. 도메인은 역할에 따라 아래와 같이 구분한다.
- 게임 시작을 위한 세팅 : `Settings`
  - 서킷 생성을 위한 자동차 입력 : `InputNames, CarVehicle, CarName, CarPosition`
  - 서킷 생성을 위한 게임 라운드 입력 : `RacingRound`
- `Circuit` : 사용자 입력값으로부터 만들어진 자동차 경주 경기장

## 2주차 요구사항
1. 일급콜렉션 활용
- `Circuit` : 경주 자동차(이름, 위치) List<CarVehicle> 포장
- `InputNames` : 자동차 이름 리스트 List<String> 포장
2. 모든 원시값과 문자열 포장
- `CarName` : 자동차 이름 String 포장
- `CarPosition` : 자동차 위치 int 포장 
- `RacingRound` : 경기횟수 int 포장

## 구현 기능
### Main
- AppConfig를 통해 객체를 생성하고 의존성을 주입한다. (Singleton 패턴)
- `GameView.gameplay()` 를 통해 게임을 시작하고, 게임이 끝나면 종료한다.

### View
- 생성자를 통해 객체 생성 시점에 필요한 객체를 주입 받는다. (Settings, GameRule)
- `playGame()` : 전체 게임의 흐름을 제어한다.
- 게임 흐름 : Settings -> Circuit 생성 -> GameRule 우승자 선정

### Config
- AppConfig 클래스를 통해 각 객체 별 의존성 주입 관계를 정의한다.

### Settings
- `createCircuit()` : 자동차 경주에 참가할 자동차를 입력받아 출발점에 위치시킨다.
  - InputNames : 일급 컬렉션을 이용한 자동차 이름 중복 금지
  - CarName : 자동차 이름 원시값을 포장하여 5글자 이상 자동차 입력 금지
- `createRound()` : 자동차 경주를 진행할 게임 횟수를 입력받는다.

### 도메인
1. Circuit (일급 컬렉션 : First class collection)
- 경기에 참가할 자동차 리스트를 관리한다.
- 경기에 참가할 수 있는 최대 자동차의 개수는 10,000대이다.(자체 제약 설정)

2. Vehicle(CarVehicle)
- `go()` : 랜덤값에 의해 전진, 멈춤이 결정된다.

3. GameRule (Interface) -> RacingGameRule
- Vehicle 들의 최종위치를 확인하고, 1등을 결정한다.
- `List<String> getResult(Circuit circuit)` : 서킷에서 가장 멀리 전진한 자동차를 찾아 반환한다.

## Utils
1. ExceptionMessage : Exception 발생 시 ERROR 메시지 관리
2. GameMessage : 게임과 관련된 각종 출력 메시지 관리
3. PrintUtils : 시스템 출력 함수 Wrapping

## Test
1. 일급 컬렉션 사용에 대한 테스트 : CircuitTest, InputNamesTest
2. 원시값 포장에 대한 테스트 : CarNameTest, CarPositionTest, RacingRoundTest
3. 초기 세팅값 입력에 대한 테스트 : SettingsTest