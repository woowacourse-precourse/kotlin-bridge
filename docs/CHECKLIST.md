# 요구 사항 체크 리스트


## 3주 차 공통 피드백

- [X] 함수(메서드) 라인에 대한 기준
- [X] 발생할 수 있는 예외 상황에 대해 고민한다
- [X] 비지니스 로직과 UI 로직을 분리한다
- [X] 연관성 있는 상수는 전역으로 선언하는 대신 enum 을 활용한다
- [X] val 키워드를 사용해 값의 변경을 막는다
- [X] 객체 상태 접근을 제한한다
- [X] 객체는 객체스럽게 사용한다
- [X] 필드의 수를 줄이기 위해 노력한다
- [X] 성공하는 케이스 뿐만 아니라 예외에 대한 케이스도 테스트한다
- [X] 테스트 코드도 코드다
  - 테스트 코드도 리팩토링해가며 코드를 개선해가라
  - 특히 반복적으로 하는 부분을 중복되지 않게 만들어야 한다
- [X] 테스트를 위한 코드는 구현 코드에서 분리되어야 한다
  - 테스트를 위해 접근 제어자를 바꾸는 경우
  - 테스트 코드에서만 사용되는 메서드
- [X] 단위 테스트하기 어려운 코드를 단위 테스트하기
  - 참고. ([메서드 시그니처를 수정하여 테스트하기 좋은 메서드로 만들기](https://tecoble.techcourse.co.kr/post/2020-05-07-appropriate_method_for_test_by_parameter/))
- [X] private 함수를 테스트하고 싶다면 클래스(객체) 분리를 고려한다


## 프로그래밍 요구 사항

- [X] Kotlin 1.6.20에서 실행 가능해야 한다. **Kotlin 1.6.20에서 정상적으로 동작하지 않을 경우 0점 처리한다.**
- [X] **Java 코드가 아닌 Kotlin 코드로만 구현해야 한다.**
- [X] 프로그램 실행의 시작점은 `Application`의 `main()`이다.
- [X] `build.gradle(.kts)`을 변경할 수 없고, 외부 라이브러리를 사용하지 않는다.
- [X] [Kotlin 코드 컨벤션](https://github.com/woowacourse/woowacourse-docs/tree/main/styleguide/kotlin) 가이드를 준수하며 프로그래밍한다.
- [X] 프로그램 종료 시 `System.exit()`를 호출하지 않는다.
- [X] 프로그램 구현이 완료되면 `ApplicationTest`의 모든 테스트가 성공해야 한다. **테스트가 실패할 경우 0점 처리한다.**
- [X] 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 이름을 수정하거나 이동하지 않는다.
- [X] indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
- [X] 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- [X] JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인한다.
- [X] else를 지양한다.
- [X] 도메인 로직에 단위 테스트를 구현해야 한다. 단, UI(println, readLine 등) 로직은 제외한다.


## 추가된 요구 사항

- [X] 함수(또는 메서드)의 길이가 10라인을 넘어가지 않도록 구현한다.
- [X] 메서드의 파라미터 개수는 최대 3개까지만 허용한다.
- [X] 아래 있는 `InputView`, `OutputView`, `BridgeGame`, `BridgeMaker`, `BridgeRandomNumberGenerator` 클래스의 요구사항을 참고하여 구현한다.
  - [X] `InputView` 클래스에서만 `camp.nextstep.edu.missionutils.Console` 의 `readLine()` 메서드를 이용해 사용자의 입력을 받을 수 있다.
  - [X] `BridgeGame` 클래스에서 `InputView`, `OutputView` 를 사용하지 않는다.

### InputView 클래스

- [X] 제공된 `InputView` 클래스를 활용해 구현해야 한다.
- [X] `InputView`의 패키지는 변경할 수 있다.
- [X] `InputView`의 메서드의 시그니처(인자, 이름)와 반환 타입은 변경할 수 있다.
- [X] 사용자 값 입력을 위해 필요한 메서드를 추가할 수 있다.

### OutputView 클래스

- [X] 제공된 `OutputView` 클래스를 활용해 구현해야 한다.
- [X] `OutputView`의 패키지는 변경할 수 있다.
- [X] `OutputView`의 메서드의 이름은 변경할 수 없고, 인자와 반환 타입은 필요에 따라 추가하거나 변경할 수 있다.
- [X] 값 출력을 위해 필요한 메서드를 추가할 수 있다.


### BridgeGame 클래스

- [X] 제공된 `BridgeGame` 클래스를 활용해 구현해야 한다.
- [X] `BridgeGame`에 필드를 추가할 수 있다.
- [X] `BridgeGame`의 패키지는 변경할 수 있다.
- [X] `BridgeGame`의 메서드의 이름은 변경할 수 없고, 인자와 반환 타입은 필요에 따라 추가하거나 변경할 수 있다.
- [X] 게임 진행을 위해 필요한 메서드를 추가하거나 변경 할 수 있다.

### BridgeMaker 클래스

- [X] 제공된 `BridgeMaker` 클래스를 활용해 구현해야 한다.
- [X] `BridgeMaker`의 필드를 변경할 수 없다.
- [X] `BridgeMaker`의 메서드의 시그니처(인자, 이름)와 반환 타입은 변경할 수 없다.


### BridgeRandomNumberGenerator 클래스

- [X] Random 값 추출은 제공된 `bridge.BridgeRandomNumberGenerator`의 `generate()`를 활용한다.
- [X] `BridgeRandomNumberGenerator`, `BridgeNumberGenerator` 클래스의 코드는 변경할 수 없다.

### 라이브러리

- [X] [`camp.nextstep.edu.missionutils`](https://github.com/woowacourse-projects/mission-utils)에서 제공하는 `Console` API를 사용하여
  구현해야 한다.
  - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.

