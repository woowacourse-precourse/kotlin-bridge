# 미션 - 다리 건너기

## 3주차 피드백
1. main()함수도 15라인 적용
2. 연관성이 있는 상수는 전역으로 선언하는 대신 enum을 활용한다.
3. 객체는 객체스럽게 사용한다. (단순히 데이터를 주는 get이 아니라 데이터를 가공해 메세지를 던지도록 설계한다.)
4. 객체의 필드의 수를 줄이기 위해 노력한다.
5. 테스트 코드도 코드다.
6. 테스트를 위한 코드는 구현 코드에서 분리되어야 한다
    - 테스트를 위해 접근 제어자를 바꾸는 경우
    - 테스트 코드에서만 사용되는 메서드
7. private 함수를 테스트 하고 싶다면 클래스(객체) 분리를 고려한다


----

## 기능 구현 목록

### Input
사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 **그 부분부터 입력을 다시 받는다.**
- [x] 다리의 길이를 입력받는다. - `readBridgeSize()`
    - [x] 기대하는 입력값이 아닌 경우 예외 처리(문자, 3 이상 20 이하의 숫자, )
- [x] 이동할 칸 위(U) 또는 아래(D)를 입력받는다. - `readMoving()`
    - [x] U 또는 D가 아닐 경우 예외 처리 (소문자는 생각 중..) `이동할 때 위 칸은 대문자 U, 아래 칸은 대문자 D를 입력한다.` 라고 말해서 소문자도 예외 처리 해야할 듯?
- [x] 다리를 끝까지 건너면 실패하면 재시작 또는 종료를 선택한다. - `readGameCommand()`
    - [x] R 또는 Q가 아닐 경우 예외 처리
    - [x] 재시작할 경우 만든 다리는 재사용한다. -> position 초기화(BridgeGame.kt)

### Output
- [x] 이동한 칸까지 지나온 경로(map)을 표시한다. 실패해도 표시한다. - `printMap()`
- [x] 이동에 실패한 경우 재시작 여부를 묻는 메세지를 표시한다. - `printRetry()`
- [x] 최종으로 지나온 경로를 보여주고, 게임 성공 여부, 총 시도 횟수를 출력한다. - `printResult()`

### Bridge

#### Bridge - BridgeGame
- [x] 만들어진 맵(리스트)과 사용자의 이동할 입력을 갖고 이동한다. - `move()`
- [x] 이동에 실패했을 경우 재시작 로직을 가동한다. - `retry()`
- [x] 이동한 칸을 bridge와 비교하여 건널 수 있는지 없는지 판단한다. `calculateIsMovable()`
#### Bridge - BridgeMaker
- [ ] 랜덤으로 다리(U와 D로 이루어진 list)를 생성한다. (인자: 다리의 길이)

### Rule
- [x] 입력 값이 요구 사항에 따라 옳바르게 입력됐는지 확인한다.


## 🎯 프로그래밍 요구 사항

- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
  - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
  - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인한다.
- else를 지양한다.
  - 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
  - 때로는 if/else, when문을 사용하는 것이 더 깔끔해 보일 수 있다. 어느 경우에 쓰는 것이 적절할지 스스로 고민해 본다.
- 도메인 로직에 단위 테스트를 구현해야 한다. 단, UI(println, readLine 등) 로직은 제외한다.
  - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 분리해 구현한다.

### 추가된 요구 사항

- [x] 함수(또는 메서드)의 길이가 10라인을 넘어가지 않도록 구현한다.
  - [x] 함수(또는 메서드)가 한 가지 일만 잘하도록 구현한다.
- [x] 메서드의 파라미터 개수는 최대 3개까지만 허용한다.
- [x] 아래 있는 `InputView`, `OutputView`, `BridgeGame`, `BridgeMaker`, `BridgeRandomNumberGenerator` 클래스의 요구사항을 참고하여 구현한다.
  - 각 클래스의 제약 사항은 아래 클래스별 세부 설명을 참고한다.
  - 이외 필요한 클래스(또는 객체)와 메서드는 자유롭게 구현할 수 있다.
  - [x] `InputView` 클래스에서만 `camp.nextstep.edu.missionutils.Console` 의 `readLine()` 메서드를 이용해 사용자의 입력을 받을 수 있다.
  - `BridgeGame` 클래스에서 `InputView`, `OutputView` 를 사용하지 않는다.

### InputView 클래스

- [x] 제공된 `InputView` 클래스를 활용해 구현해야 한다.
- [x] `InputView`의 패키지는 변경할 수 있다.
- [x] `InputView`의 메서드의 시그니처(인자, 이름)와 반환 타입은 변경할 수 있다.
- [x] 사용자 값 입력을 위해 필요한 메서드를 추가할 수 있다.

```kotlin
class InputView {
    fun readBridgeSize(): Int {
        return 0
    }
    fun readMoving(): String {
        return ""
    }
    fun readGameCommand(): String {
        return ""
    }
}
```

### OutputView 클래스

- [x] 제공된 `OutputView` 클래스를 활용해 구현해야 한다.
- [x] `OutputView`의 패키지는 변경할 수 있다.
- [x] `OutputView`의 메서드의 이름은 변경할 수 없고, 인자와 반환 타입은 필요에 따라 추가하거나 변경할 수 있다.
- [x] 값 출력을 위해 필요한 메서드를 추가할 수 있다.

```kotlin
class OutputView {
    fun printMap() {}
    fun printResult() {}
}
```

### BridgeGame 클래스

- [x] 제공된 `BridgeGame` 클래스를 활용해 구현해야 한다.
- [x] `BridgeGame`에 필드를 추가할 수 있다.
- [x] `BridgeGame`의 패키지는 변경할 수 있다.
- [x] `BridgeGame`의 메서드의 이름은 변경할 수 없고, 인자와 반환 타입은 필요에 따라 추가하거나 변경할 수 있다.
- [x] 게임 진행을 위해 필요한 메서드를 추가하거나 변경 할 수 있다.

```kotlin
class BridgeGame {
    fun move() {}
    fun retry() {}
}
```

### BridgeMaker 클래스

- [x] 제공된 `BridgeMaker` 클래스를 활용해 구현해야 한다.
- [x] `BridgeMaker`의 필드를 변경할 수 없다.
- [x] `BridgeMaker`의 메서드의 시그니처(인자, 이름)와 반환 타입은 변경할 수 없다.

```kotlin
class BridgeMaker(private val bridgeNumberGenerator: BridgeNumberGenerator) {
    fun makeBridge(size: Int): List<String> {
        return listOf()
    }
}
```

### BridgeRandomNumberGenerator 클래스

- Random 값 추출은 제공된 `bridge.BridgeRandomNumberGenerator`의 `generate()`를 활용한다.
- `BridgeRandomNumberGenerator`, `BridgeNumberGenerator` 클래스의 코드는 변경할 수 없다.

#### 사용 예시

- 다리 칸을 생성하기 위한 Random 값은 아래와 같이 추출한다.

```kotlin
val number = bridgeNumberGenerator.generate()
```

- [ ] 도메인 별로 테스트를 작성했는가? (참고: https://tecoble.techcourse.co.kr/post/2020-05-07-appropriate_method_for_test_by_parameter/)
- [x] 객체는 객체스럽게 사용했는가?