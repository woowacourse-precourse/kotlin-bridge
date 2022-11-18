## 🚀 기능 목록

## ⌨️ Service Logic :
### 1. InputView (사용자입력) : `@datatype : String`
1. **자동으로 생성할 다리 길이를 입력 받는다.** `readBridgeSize()`
  - [x] 입력 안내문 : `다리의 길이를 입력해주세요.`
  - [x] 콘솔입력 `camp.nextstep.edu.missionutils.Console의 readLine()`
    - [x] 3 이상 20 이하의 숫자를 입력할 수 있다.
    - **예외처리** `IllegalArgumentException`
    - [x] `@toInt` 3~20 숫자가아닌 경우
    - [x] 에러 문구는 "[ERROR]"로 시작해야 한다.
    - [x] 에러 메시지를 출력 후 입력을 다시 받는다.

2. **라운드마다 플레이어가 이동할 칸을 입력 받는다** `readMoving()`
  - [x] 입력 안내문 : `이동할 칸을 선택해주세요. (위: U, 아래: D)`
  - [x] 콘솔입력 `camp.nextstep.edu.missionutils.Console의 readLine()`
    - [x] U(위 칸)와 D(아래 칸) 중 하나의 문자를 입력할 수 있다.
    - **예외처리** `IllegalArgumentException`
    - [x] U또는 D가 아닌 경우
    - [x] 에러 문구는 "[ERROR]"로 시작해야 한다.
    - [x] 에러 메시지를 출력 후 입력을 다시 받는다.
3. **게임 재시작/종료 여부를 입력 받는다.** `readGameCommand()`
  - [x] 입력 안내문 : `게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)
    `
  - [x] 콘솔입력 `camp.nextstep.edu.missionutils.Console의 readLine()`
    - [x] R(재시작)과 Q(종료) 중 하나의 문자를 입력할 수 있다. 
    - **예외처리** `IllegalArgumentException`
      - [x] R또는 Q가 아닌 경우
      - [x] 에러 문구는 "[ERROR]"로 시작해야 한다.
      - [x] 에러 메시지를 출력 후 입력을 다시 받는다.

### 2. OutputView (출력) 
1. 게임시작 문구 `printGameStart()`
   - [ ] 콘솔출력: `다리 건너기 게임을 시작합니다.`
2. 현재까지 이동한 다리 출력 `printMap()`
   - [ ] 콘솔출력
3. 게임 종료 문구 `printGameResult()`
   - [ ] 콘솔출력: `최종 게임 결과`
   - [ ] 콘솔출력: 이동한 다리 출력 `printMap()`
   - [ ] 콘솔출력: `게임 성공 여부 : ${isSuccess}`
   - [ ] 콘솔출력: `총 시도한 횟수: ${round}`


## 🧮 Domain Logic
### 1.BridgeNumberGenerator, BridgeRandomNumberGenerator
  - [x] 0과 1 중 무작위 값을 이용해서 정한다.
### 2. BridgeMaker
  - [x] 세로길이2 , 가로길이 $size인 다리를 `$BridgeNumberGenerator.generate()` 호출해서 만든다.
  - [x] enum {0: D, 1: U}로 표현한다.

### 3. BridgeGame
- BridgeGame 클래스에서 InputView, OutputView 를 사용하지 않는다.
  - [ ] 클래스 생성자 `BridgeGame.init()`
    - [ ] 다리를 만든다.`BridgeMaker.makeBridge()`
  - [ ] 다리를 이동한다. `$BridgeGame.move()`
    - [ ] 현재까지의 Map을 가져온다.
    - [ ] 플레이어 이동할 칸을 입력 받는다 `InputView.readMoving()`
    - [ ] 현재 위치의 칸을 건널 수 있다면 O로 표시한다. 건널 수 없다면 X로 표시하여 Map을업데이트한다.
  - [ ] 플레이어가 다리를 건넜는지 확인한다. `BridgeGame.isFinished()` 
    - [ ] 현재 위치의 칸이 끝인지 확인한다.
    - [ ] 현재 위치의 칸이 끝이면 true를 반환한다.
  - [ ] 플레이어가 다리를 건너다 실패 했는지 확인한다. `BridgeGame.isFailed()`
    - [ ] 현재 위치의 칸이 X인지 확인한다.
    - [ ] 현재 위치의 칸이 X이면 true를 반환한다.
  
### 4. main
  - [ ] 게임시작 문구 `OutputView.printGameStart()`
  - [ ] 다리 길이를 입력 받는다. `InputView.readBridgeSize()`
  - [ ] 다리를 생성한다. `val bridge = BridgeGame(bridgeMaker, size)`
  - [ ] 반복문 `play(bridge) : round, isSuccess`
    - [ ] 다리를 이동한다. `var curBridge = BridgeGame.move(InputView.readMoving())`
    - [ ] 현재 다리를 출력한다. `OutputView.printMap(curBridge)`
    - [ ] 플레이어가 다리를 건넘에 실패 했는지 확인한다. `BridgeGame.isFailed(curBridge)`
        - [ ] 실패 했다면 게임 재시작 여부를 입력 받는다. `InputView.readRestart()`
    - [ ] 플레이어가 다리를 건넘에 성공 했는지 확인한다. `BridgeGame.isFinished(curBridge)`
        - [ ] 성공 했다면 게임을 종료한다. `break`
  - [ ] 게임 결과 출력 `OutputView.printGameResult()`
    - [ ] 게임 결과의 총 시도한 횟수는 첫 시도를 포함해 게임을 종료할 때까지 시도한 횟수를 나타낸다.



---
## 📌 비기능 요구사항 목록
- **Commit Convention**
  - Git의 커밋([커밋 메시지 컨벤션](https://gist.github.com/stephenparish/9941e89d80e2bc58a153)) 단위는 앞 단계에서 `docs/README.md`에 정리한 기능 목록 단위로 추가.
  - Format of the commit message
    ```
    <type>(<scope>): <subject>
    <BLANK LINE>
    <body>
    <BLANK LINE>
    <footer>
    ```

- **Coding Convention**
  - [Kotlin 코드 컨벤션](https://github.com/woowacourse/woowacourse-docs/tree/main/styleguide/kotlin) 가이드를 준수
  - [코틀린 스타일 가이드](https://developer.android.com/kotlin/style-guide?hl=ko)
  - [클린 코드 체크 리스트](https://github.com/woowacourse/woowacourse-docs/blob/main/cleancode/pr_checklist.md)
  - indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다.
  - Java 코드가 아닌 Kotlin 코드로만 구현해야 한다.
  - 함수(또는 메서드)의 길이가 10라인을 넘어가지 않도록 구현한다.
  - 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.
  - 메서드의 파라미터 개수는 최대 3개까지만 허용한다.
  - Enum 클래스를 적용해 프로그래밍을 구현한다.

- **Test**
  - JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인
  - 도메인 로직에 단위 테스트를 구현해야 한다. 단, UI(System.out, System.in, Scanner) 로직은 제외한다.
  - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 분리해 구현한다.
  - 단위 테스트 작성이 익숙하지 않다면 `test/kotlin/lotto/LottoTest`를 참고하여 학습한 후 테스트를 구현한다.
- **Allowed Libraries**
  - 아래의 허용된 라이브러리 외 외부 라이브러리를 사용하지 않는다.
  - `camp.nextstep.edu.missionutils.Console`
  - `camp.nextstep.edu.missionutils.Randoms`