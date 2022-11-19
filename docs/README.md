## 🎯기능 목록

- 다리건너기 게임진행 관련 기능 - `BridgeGame.kt` : `Class`
    - 사용자가 칸을 이동한다 - `move()`
    - 재시작을 한다 - `retry()`


- 다리만들기 관련 기능 - `BridgeMaker.kt` : `Class`
    - 다리를 만든다. - `makeBridge()`


- 다리번호 랜덤 생성 관련 기능 - `BridgeRandomNumberGenerator.kt` : `Class`
    - 다리를 구성하는 번호을 랜덤으로 생성한다. - `generate()`

    
- 사용자 입출력 관련 기능
    - 입력 - `InputView` : `Class`
        - 다리의 길이를 입력한다. - `readBridgeSize()`
        - 사용자가 이동할 칸을 입력받는다. - `readmoving()`
        - 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다. - `readGameCommand()`

    - 출력 - `OutputView` : `Class`
        - 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다. - `printMap()`
        - 게임의 최종 결과를 정해진 형식에 맞춰 출력한다. - `printResult()`


- 예외
    - 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
      Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.

---

### 💭 브릿지 게임의 큰 흐름을 한눈에 보기 위한 순서도
![순서도]()

[🔍 브릿지 게임 순서도 웹에서 자세히보기 (위 이미지는 해상도가 낮습니다.)]()

---

## ✅ 체크리스트

- [ ] kotlin 코드 컨벤션 가이드를 지켰는가?
- [ ] 변수, 또는 메소드 이름을 통해 의미를 전달 했는가?
- [ ] indent depth가 3이 넘지 않도록 구현 했는가?
- [ ] AssertJ를 이용하여 기능 목록이 정상 동작함을 테스트 코드로 확인 했는가?
- [ ] `camp.nextstep.edu.missionutils`에서 제공하는 API를 사용하여 구현 했는가?
- [ ] 깃 커밋 메시지 컨벤션 가이드를 지켰는가?
- [ ] 함수(또는 메소드)가 한 가지 일만 하는가?
- [ ] 함수(또는 메소드)의 파라미터가 3개를 넘지 않았는가?
- [ ] 함수(또는 메소드)의 길이가 10라인을 넘어가지 않았는가?
- [ ] `else`를 지양했는가?
- [ ] 도메인 로직에 단위 테스트를 구현했는가?