## Feature List
1. 문제 요구사항 파악
    1. 입력으로 다리의 길이를 입력 받는다. 이때, 다리의 길이는 3부터 20까지의 정수이다.
    2. 다리가 생성된 후, 사용자에게 U(위), D(아래)를 입력 받아 다리 건너기 게임을 진행한다.
    3. 만약 이동할 수 있는 다리라면 O를, 아니라면 X를 경로에 저장하고, O일 때는 게임을 계속 진행, X일 때는 재시도 혹은 종료를 입력 받을 수 있게 한다.
    4. 이때, 재시도를 입력 받게 되면 똑같은 다리를 갖고 그대로 다리 건너기 게임을 진행한다.
    5. 게임 종료(다리 건너기 실패 후 종료 혹은 다리 건너기 성공) 후 게임 결과 출력 후, 게임 성공 여부와 시도 횟수를 출력한다.
    6. 아래의 규칙을 준수하도록 한다.

    ```
    - 사용자가 이동할 때마다 다리 건너기 결과의 출력 형식은 실행 결과 예시를 참고한다.
    - 이동할 수 있는 칸을 선택한 경우 O 표시
    - 이동할 수 없는 칸을 선택한 경우 X 표시
    - 선택하지 않은 칸은 공백 한 칸으로 표시
    - 다리의 시작은 `[`, 다리의 끝은 `]`으로 표시
    - 다리 칸의 구분은 ` | `(앞뒤 공백 포함) 문자열로 구분
    - 현재까지 건넌 다리를 모두 출력
    - 예외 상황 시 에러 문구를 출력해야 한다. 단, 에러 문구는 "[ERROR]"로 시작해야 한다.
    - [ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.
    ```

    + 요구하는 입출력 형식을 확인할 것

    6. 추가 요구사항
    ```
    추가 요구 사항
    - 함수(또는 메서드)의 길이가 10라인을 넘어가지 않도록 구현한다.
    - 함수(또는 메서드)가 한 가지 일만 잘하도록 구현한다.
    - 메서드의 파라미터 개수는 최대 3개까지만 허용한다.
    - 아래 있는 `InputView`, `OutputView`, `BridgeGame`, `BridgeMaker`, `BridgeRandomNumberGenerator` 클래스의 요구사항을 참고하여 구현한다.
      - 각 클래스의 제약 사항은 아래 클래스별 세부 설명을 참고한다.
      - 이외 필요한 클래스(또는 객체)와 메서드는 자유롭게 구현할 수 있다.
      - `InputView` 클래스에서만 `camp.nextstep.edu.missionutils.Console` 의 `readLine()` 메서드를 이용해 사용자의 입력을 받을 수 있다.
      - `BridgeGame` 클래스에서 `InputView`, `OutputView` 를 사용하지 않는다.
    ```

2. 예외 처리
    + 잘못된 값을 입력 받을 경우 IllegalArgumentException를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 시키라고 명시되어 있다.
    + 잘못된 값이라 하면 다음과 같은 예외 상황이 있다.
        + 다리의 길이 입력 시 - 다리 길이가 정수가 아닌 경우 / 3이상 20이하가 아닌 경우가 있다.
        + 게임 이동 시 - U(위 칸), D(아래 칸) 이외의 값을 입력할 경우
        + 게임 재시작, 종료 여부 입력 시 - R(재시작), Q(종료) 이외의 값을 입력할 경우
    + 이 외에 예외 발생 시 IllegalStateException를 발생시키도록 한다.

3. 클래스
    + basic으로 주어지는 class를 활용해야 한다.
    + basic class : InputView, OutputView, BridgeGame, BridgeMaker, BridgeRandomNumberGenerator
    + InputView 클래스에서만 camp.nextstep.edu.missionutils.Console 의 readLine() 메서드를 이용해 사용자의 입력을 받을 수 있다.
    + BridgeGame 클래스에서 InputView, OutputView 를 사용하지 않는다.
    + InputView 클래스 : 사용자 입력에 관한 모든 view를 처리하도록 한다.
    + OutputView 클래스 : 출력과 관련된 모든 view를 처리하도록 한다. (맵 출력, 결과 출력 등, 이때, 기존에 있는 함수명 변경 불가)
    + BridgeGame 클래스 : 다리 건너기 게임 진행, 재시도 관련 이벤트 Controller 역할
    + BridgeMaker 클래스 : 생성자로 BridgeNumberGenerator가 있다.
    + BridgeRandomNumberGenerator 클래스 : 라이브러리 bridge.BridgeRandomNumberGenerator의 generate()를 이용해 다리(한 칸) 생성 / 변경 불가


3. 함수
    1. BridgeSizeException 클래스

   | 함수명 | 매개변수 | 리턴타입 | 용도 |
       | --- | --- | --- | --- |
   | isNotInteger | String inputData | Boolean | 입력값 정수인지 check |
   | isNotBridgeNumber | String inputData | Boolean | 입력값 3이상 20 이하의 수인지 check |

    2. BridgeMoveException 클래스

   | 함수명 | 매개변수 | 리턴타입 | 용도 |
       | --- | --- | --- | --- |
   | isNotMoveCharacter | String inputData | Boolean | 입력값 'U' 혹은 'D'인지 check |

    3. GameCommandException 클래스

   | 함수명 | 매개변수 | 리턴타입 | 용도 |
       | --- | --- | --- | --- |
   | isNotExitCharacter | String inputData | Boolean | 입력값 'R' 혹은 'Q'인지 check |

    4. InputView 클래스

   | 함수명 | 매개변수 | 리턴타입 | 용도 |
       | --- | --- | --- | --- |
   | inputBridgeSize |  | Int | 다리 길이 입력 받아 예외 처리 후 return |
   | inputMoveIndex |  | String | 이동할 칸 입력 받아 예외 처리 후 return |
   | inputExit |  | String | 게임 재시작, 종료 여부 입력 받아 예외 처리 후 return |

    5. OutputView 클래스

   | 함수명 | 매개변수 | 리턴타입 | 용도 |
       | --- | --- | --- | --- |
   | printMap |  |  | 터미널에 '맵의 정보' 출력 |
   | printResult | gameResult: Boolean, tryCount: Int |  | 터미널에 '게임 결과 출력' 출력 |

    6. BridgeGame 클래스

   | 함수명 | 매개변수 | 리턴타입 | 용도 |
       | --- | --- | --- | --- |
   | move | moveData: Int |  | moveData 값을 읽어 게임 진행 |
   | retry | gameCommand:  |  | gameCommand 값을 읽어 게임 종료 및 재시작 설정 |

    7. BridgeMaker 클래스 - 생성자 private val bridgeNumberGenerator: BridgeNumberGenerator

   | 함수명 | 매개변수 | 리턴타입 | 용도 |
       | --- | --- | --- | --- |
   | makeBridge | size: Int | List-String | 사이즈만큼 반복해 다리 정보를 담은 List 생성 후 return |

    8. BridgeController 클래스

    + InputView와 OutputView, Bridge 클래스들을 이용해 게임 진행
    + init에서 초기 생성 시 다리 길이를 입력 받도록하고, 그 다리 길이만큼 다리를 생성하도록 한다.

   | 함수명 | 매개변수 | 리턴타입 | 용도 |
       | --- | --- | --- | --- |
   | startBridgeGame |  |  | 다리 건너기 게임 진행 |

---
## 문제 - 다리 건너기

## 🚀 기능 요구 사항

위아래 둘 중 하나의 칸만 건널 수 있는 다리를 끝까지 건너가는 게임이다.

- 위아래 두 칸으로 이루어진 다리를 건너야 한다.
    - 다리는 왼쪽에서 오른쪽으로 건너야 한다.
    - 위아래 둘 중 하나의 칸만 건널 수 있다.
- 다리의 길이를 숫자로 입력받고 생성한다.
    - 다리를 생성할 때 위 칸과 아래 칸 중 건널 수 있는 칸은 0과 1 중 무작위 값을 이용해서 정한다.
    - 위 칸을 건널 수 있는 경우 U, 아래 칸을 건널 수 있는 경우 D값으로 나타낸다.
    - 무작위 값이 0인 경우 아래 칸, 1인 경우 위 칸이 건널 수 있는 칸이 된다.
- 다리가 생성되면 플레이어가 이동할 칸을 선택한다.
    - 이동할 때 위 칸은 대문자 U, 아래 칸은 대문자 D를 입력한다.
    - 이동한 칸을 건널 수 있다면 O로 표시한다. 건널 수 없다면 X로 표시한다.
- 다리를 끝까지 건너면 게임이 종료된다.
- 다리를 건너다 실패하면 게임을 재시작하거나 종료할 수 있다.
    - 재시작해도 처음에 만든 다리로 재사용한다.
    - 게임 결과의 총 시도한 횟수는 첫 시도를 포함해 게임을 종료할 때까지 시도한 횟수를 나타낸다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
    - `Exception`이 아닌 `IllegalArgumentException`, `IllegalStateException` 등과 같은 명확한 유형을 처리한다.

### 입출력 요구 사항

#### 입력

- 자동으로 생성할 다리 길이를 입력 받는다. 3 이상 20 이하의 숫자를 입력할 수 있으며 올바른 값이 아니면 예외 처리한다.

```
3
```

- 라운드마다 플레이어가 이동할 칸을 입력 받는다. U(위 칸)와 D(아래 칸) 중 하나의 문자를 입력할 수 있으며 올바른 값이 아니면 예외 처리한다.

```
U
```

- 게임 재시작/종료 여부를 입력 받는다. R(재시작)과 Q(종료) 중 하나의 문자를 입력할 수 있으며 올바른 값이 아니면 예외 처리한다.

```
R
```

#### 출력

- 게임 시작 문구

```
다리 건너기 게임을 시작합니다.
```

- 게임 종료 문구

```
최종 게임 결과
[ O |   |   ]
[   | O | O ]

게임 성공 여부: 성공
총 시도한 횟수: 2
```

- 사용자가 이동할 때마다 다리 건너기 결과의 출력 형식은 실행 결과 예시를 참고한다.
    - 이동할 수 있는 칸을 선택한 경우 O 표시
    - 이동할 수 없는 칸을 선택한 경우 X 표시
    - 선택하지 않은 칸은 공백 한 칸으로 표시
    - 다리의 시작은 `[`, 다리의 끝은 `]`으로 표시
    - 다리 칸의 구분은 ` | `(앞뒤 공백 포함) 문자열로 구분
    - 현재까지 건넌 다리를 모두 출력
- 예외 상황 시 에러 문구를 출력해야 한다. 단, 에러 문구는 "[ERROR]"로 시작해야 한다.

```
[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.
```

#### 실행 결과 예시

```
다리 건너기 게임을 시작합니다.

다리의 길이를 입력해주세요.
3

이동할 칸을 선택해주세요. (위: U, 아래: D)
U
[ O ]
[   ]

이동할 칸을 선택해주세요. (위: U, 아래: D)
U
[ O | X ]
[   |   ]

게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)
R
이동할 칸을 선택해주세요. (위: U, 아래: D)
U
[ O ]
[   ]

이동할 칸을 선택해주세요. (위: U, 아래: D)
D
[ O |   ]
[   | O ]

이동할 칸을 선택해주세요. (위: U, 아래: D)
D
[ O |   |   ]
[   | O | O ]

최종 게임 결과
[ O |   |   ]
[   | O | O ]

게임 성공 여부: 성공
총 시도한 횟수: 2
```

```
다리 건너기 게임을 시작합니다.

다리의 길이를 입력해주세요.
3

이동할 칸을 선택해주세요. (위: U, 아래: D)
U
[ O ]
[   ]

이동할 칸을 선택해주세요. (위: U, 아래: D)
U
[ O | X ]
[   |   ]

게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)
Q
최종 게임 결과
[ O | X ]
[   |   ]

게임 성공 여부: 실패
총 시도한 횟수: 1
```

---

## 🎯 프로그래밍 요구 사항

- Kotlin 1.6.20에서 실행 가능해야 한다. **Kotlin 1.6.20에서 정상적으로 동작하지 않을 경우 0점 처리한다.**
- **Java 코드가 아닌 Kotlin 코드로만 구현해야 한다.**
- 프로그램 실행의 시작점은 `Application`의 `main()`이다.
- `build.gradle(.kts)`을 변경할 수 없고, 외부 라이브러리를 사용하지 않는다.
- [Kotlin 코드 컨벤션](https://github.com/woowacourse/woowacourse-docs/tree/main/styleguide/kotlin) 가이드를 준수하며 프로그래밍한다.
- 프로그램 종료 시 `System.exit()`를 호출하지 않는다.
- 프로그램 구현이 완료되면 `ApplicationTest`의 모든 테스트가 성공해야 한다. **테스트가 실패할 경우 0점 처리한다.**
- 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 이름을 수정하거나 이동하지 않는다.
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

- 함수(또는 메서드)의 길이가 10라인을 넘어가지 않도록 구현한다.
    - 함수(또는 메서드)가 한 가지 일만 잘하도록 구현한다.
- 메서드의 파라미터 개수는 최대 3개까지만 허용한다.
- 아래 있는 `InputView`, `OutputView`, `BridgeGame`, `BridgeMaker`, `BridgeRandomNumberGenerator` 클래스의 요구사항을 참고하여 구현한다.
    - 각 클래스의 제약 사항은 아래 클래스별 세부 설명을 참고한다.
    - 이외 필요한 클래스(또는 객체)와 메서드는 자유롭게 구현할 수 있다.
    - `InputView` 클래스에서만 `camp.nextstep.edu.missionutils.Console` 의 `readLine()` 메서드를 이용해 사용자의 입력을 받을 수 있다.
    - `BridgeGame` 클래스에서 `InputView`, `OutputView` 를 사용하지 않는다.

### InputView 클래스

- 제공된 `InputView` 클래스를 활용해 구현해야 한다.
- `InputView`의 패키지는 변경할 수 있다.
- `InputView`의 메서드의 시그니처(인자, 이름)와 반환 타입은 변경할 수 있다.
- 사용자 값 입력을 위해 필요한 메서드를 추가할 수 있다.

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

- 제공된 `OutputView` 클래스를 활용해 구현해야 한다.
- `OutputView`의 패키지는 변경할 수 있다.
- `OutputView`의 메서드의 이름은 변경할 수 없고, 인자와 반환 타입은 필요에 따라 추가하거나 변경할 수 있다.
- 값 출력을 위해 필요한 메서드를 추가할 수 있다.

```kotlin
class OutputView {
    fun printMap() {}

    fun printResult() {}
}
```

### BridgeGame 클래스

- 제공된 `BridgeGame` 클래스를 활용해 구현해야 한다.
- `BridgeGame`에 필드를 추가할 수 있다.
- `BridgeGame`의 패키지는 변경할 수 있다.
- `BridgeGame`의 메서드의 이름은 변경할 수 없고, 인자와 반환 타입은 필요에 따라 추가하거나 변경할 수 있다.
- 게임 진행을 위해 필요한 메서드를 추가하거나 변경 할 수 있다.

```kotlin
class BridgeGame {
    fun move() {}

    fun retry() {}
}
```

### BridgeMaker 클래스

- 제공된 `BridgeMaker` 클래스를 활용해 구현해야 한다.
- `BridgeMaker`의 필드를 변경할 수 없다.
- `BridgeMaker`의 메서드의 시그니처(인자, 이름)와 반환 타입은 변경할 수 없다.

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

### 라이브러리

- [`camp.nextstep.edu.missionutils`](https://github.com/woowacourse-projects/mission-utils)에서 제공하는 `Console` API를 사용하여
  구현해야 한다.
    - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.

---

## ✏️ 과제 진행 요구 사항

- 미션은 [kotlin-bridge](https://github.com/woowacourse-precourse/kotlin-bridge) 저장소를 Fork & Clone해 시작한다.
- **기능을 구현하기 전 `docs/README.md`에 구현할 기능 목록을 정리**해 추가한다.
- **Git의 커밋 단위는 앞 단계에서 `docs/README.md`에 정리한 기능 목록 단위**로 추가한다.
    - [커밋 메시지 컨벤션](https://gist.github.com/stephenparish/9941e89d80e2bc58a153) 가이드를 참고해 커밋 메시지를 작성한다.
- 과제 진행 및 제출 방법은 [프리코스 과제 제출](https://github.com/woowacourse/woowacourse-docs/tree/master/precourse) 문서를 참고한다.

