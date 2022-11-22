# 💻 구현 기능 목록

--- 

## 📁 Application.kt

Application.kt는 프로그램이 동작하는데 필요한 함수들을 제공한다.

| 함수                        | 파라미터              | 반환 값           | 설명                                                                                                                                                          |
|---------------------------|-------------------|----------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `isEnd`                     | `ResponsePacketFor` | `Boolean`        | `BridgeGame`의 응답이 게임이 끝났다는 응답인지 확인한다.                                                                                                                         |
| `printProgressMessage`      | `ResponsePacketFor` | `Unit`           | `BridgeGame`의 응답에 해당하는 메시지를 `OutputView`에게 요청하여 출력한다.                                                                                                           |
| `readLineIfUserInputNeeded` | `ResponsePacketFor` | `String`         | 매개변수가 필요한 `BridgeGame`으로의 요청의 경우 유저의 입력이 필요하다. 만일 유저의 입력이 필요하면 `InputView`을 통하여 입력 받는다.                                                                         |
| `getResponsePacketFrom`     | `BridgeGame`, `ResponsePacketFor`      | `ResponsePacket` | 유저의 입력이 필요하다면 `readLineIfUserInputNeeded` 함수를 사용하여 처리하고 `BridgeGame`으로부터 응답 메시지를 받아 `ResponsePacket`으로 만들고 반환한다. 만일 잘못된 입력이 있었을 경우 에러 메시지를 출력하고 해당 입력을 다시 받도록 한다. |

### 🚨 Exception
- `InvalidRangeException`: 잘못된 범위의 수를 입력했을 때 발생시킨다.
- `RequestFormatException`: 잘못된 입력 형식을 입력했을 때 발생시킨다.

---  

## 📁 BridgeGame.kt

### 🛸 RequestType

`RequestType` 클래스는 `BridgeGame` 클래스에서 제어 가능한 요청들에 대해 사전 정의된 타입이다. `BridgeGame`가 동작하도록 하기 위해서는 이 타입 중 하나를 사용해야 한다.

```kotlin
enum class RequestType {
    LAUNCH, MOVE, RETRY, INIT, GUID_MESSAGE, NONE;
}
```



### 🛸 BridgeGame

`BridgeGame` 클래스는 BridgeGame을 관리하는 클래스이다.
`BridgeGame` 클래스는 요청(request)을 받는다면 그에 해당하는 응답(response)을 하도록 한다.

| 접근 제어자  | 함수                              | 파라미터                | 반환 값                 | 설명                                                                                                                                                                 |
|---------|---------------------------------|---------------------|----------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `public`  | `respondToRequest`                | `ReqyestType`, `String` | `ResponsePacket`       | 지정된 `request` 요청을 `acceptRequest` 함수로 전달하고 요청에 대한 응답을 반환한다.                                                                                                            |
| `private` | `acceptReuest`                    | `RequestType`, `String` | `Unit`                 | 파라미터로 요청의 종류를 전달 받아 그에 해당하는 함수로 전달하여 처리할 수 있도록 한다.                                                                                                                 |         
| `private` | `launchGame`                      | `Unit`               | `Unit`                 | `BridgeGame` 클래스가 게임을 시작하도록 만드는 함수이다. 요청자에게 게임이 시작되었다는 문구를 요청해야 한다는 `ResponsePacket`과 다리를 초기화 해야 한다는 문구 출력과 input을 요청하는 `RequestPacket`을 보내도록 설정한다.                      |
| `private` | `initBridgeChecker`               | `String`             | `Unit`                 | `BridgeGame` 클래스가 게임을 진행하는데 필요한 클래스인 `BridgeChecker` 클래스를 초기화하는 함수이다. 사용자에게 전달 받은 파라미터를 통해 크기를 설정하고 이제 어떻게 움직일 것인지 input을 요청하는 `RequestPacket`을 보내도록 설정한다.               |
| `private` | `updateWithMove`                  | `String`             | `Unit`                 | 사용자로부터 전달받은 어떻게 움직일 것인지에 대한 파라미터를 통해 `move` 함수를 실행하고 그 움직인 결과에 대한 `ResponsePacket`을 보내도록 설정한다.                                                                         |
| `private` | `makeResponsePacketByMovedResult` | `List<Boolean>`      | `List<ResponsePacket>` | `move` 함수가 호출되고 난 뒤의 결과는 3가지(실패, 성공, 진행중)으로 나뉜다. 이 함수는 이동 결과를 `String`으로 보여주는 `ResponsePacket`을 만들고 서로 다른 결과에 맞는 `ResponsePacket`을 추가적으로 만들어 2개의 `ResponsePacket`을 `List`로 반환한다. |
| `private` | `updateWithRetry`| `String`              | `Unit`                 | 게임 재시작 요청을 처리하는 함수이다. 사전에 정해진 `R`, `Q` 입력에 대해 `retry` 함수를 실행하도록 하고, `R`과 `Q`에 대해 적절한 `ResponsePacket`을 보낼 수 있도록 설정한다.                                                          |
| `private` |`move`| `String`              | `List<Boolean>`        | `BridgeChecker` 클래스에게 움직임 처리를 요청하고 그 결과를 `List`로 반환한다.|
| `private` |`retry`| `String`|`Unit`|만일 사용자 요청이 `R`이었을 경우 `BridgeChecker` 클래스가 현재까지 진행 결과를 초기화 하도록 만든다.|

- 사용 예시

```kotlin

val brideGame: BrideGame = BridgeGame()
var responsePacket = bridgeGame.respondToRequest(RequestType.LAUNCH)

//...

println(responsePacket.popMessageToPrint())

if (responsePacket.popAdditionalMessage() == RequestType.GUID_MESSAGE)
    println("RequestType.GUID_MESSAGE 요청해 달라고 전달 받았습니다.")

```

- 출력

```kotlin
다리 건너기 게임을 시작합니다 .

RequestType.GUID_MESSAGE를 요청해 달라고 전달 받았습니다.
```

### 🚨 Exception

- `acceptReuest`: 만일 사전에 지정되지 않은 요청 타입을 전달 받았을 경우 `InvalidRequestException`을 발생시킨다.
- 재시작할 때 입력이 `R` 또는 `Q`가 아닌 경우 `InvalidRangeException`을 발생시킨다.
- `BridgeChecker`가 초기화되지 않았지만 `BridgeChecker`에 접근한 경우 `NullBridgeException`을 발생시킨다.
- 숫자를 입력해야 할 때 숫자로 변환시킬 수 없는 문자열을 입력했을 경우 `RequestFormatException`을 발생시킨다.
- 다리 크기를 입력 받아 초기화 하는데 크기가 3보다 작거나 20보다 클 경우 `InvalidRangeException`을 발생시킨다.
- 입력받은 움직이는 방식이 `U` 또는 `D`가 아니었을 경우 `RequestFormatException`을 발생시킨다.
- 만일 시작하지 않은 상태에서 어떤 요청을 받았을 경우 `InvalidRequestException`을 발생시킨다.
- 만일 `BridgeGame`이 `ResponsePacket`으로 다음에 요청해야할 `RequestType`을 보냈지만 `respondToRequest`로 전달 받은 `RequestType`이 적절하지
  않으면 `InvalidRequestException`을 발생시킨다.
    - 즉, 게임의 순서에 무관한 요청은 예외처리한다.

---  

## 🛸 BridgeMaker

|함수|파라미터|반환 값| 설명                                                                                      |
|---|---|---|-----------------------------------------------------------------------------------------|
|`makeBridge`|`Int`|`List<String>`| `makeBridge` 함수는 다리 길이를 파라미터로 전달 받아 해당 하는 다리 모양을 만들어 반환한다. 위 칸이면 `U`, 아래 칸이면 `D`로 표현된다. |

### 🚨 Exception

`makeBridge` 함수는 단순히 요청 받은 `size`에 대한 다리를 생성하여 반환한다. 이 `size`에 대하여 예외 사항이 있다면 `makeBride` 함수를 요청한 쪽에서 처리하도록 한다.

---

## 🛸 BridgeChecker

`BridgeChecker` 클래스는 크기와 `BridgeMaker` 클래스를 파라미터로 전달 받아 생성된다. `BridgeMaker`로 다리를 만들고 요청에 따라 현재 진행 상황을 문자열로 전달해주는 함수와 현재 진행
상황을 갱신하는 함수, 게임 진행 내용을 초기화 하는 함수를 제공한다.

| 함수                  | 파라미터     | 반환 값   | 설명                                                                |
|---------------------|----------|--------|-------------------------------------------------------------------|
| `toVisualizationOpenedPart`    | `Unit`   | `String` | 사용자가 현재까지 다리를 얼마나 건넜는지를 문자열로 시각화하여 반환한다.                          |
|`toVisualizationGameResult`| `Unit`     |`String`| 게임 결과를 문자열로 시각화하여 반환한다.                                           |
| `checkWithUpdating`   | `String` | `Boolean` | 사용자가 입력한 정답(`U` 혹은 `D`)을 파라미터로 받아 답이 맞았는지 확인하고 갱신한 뒤 정답 여부를 반환한다. |
| `resetBridgeRevealed` | `Unit`   | `Unit` | 사용자가 다리를 건너는 진행 상황을 초기화 한다. 또한 시도 횟수는 증가한다.                       |

### 🚨 Exception

`BridgeChecker` 클래스는 어떤 크기의 `size`를 입력 받아도 생성이 가능하도록 의도했다. 주어진 "크기는 3 이상 20 이하"여야 한다라는 조건은 이 클래스 생성을 요청하는 곳에서 처리해야 한다.

---

## 🛸 BridgeRandomNumberGenerator

`BridgeRandomNumberGenerator` 클래스는 `BridgeNumberGenerator` 인터페이스를 상속받아 구현된다.
다리를 생성할 때 `U`형 다리인지 `D`형 다리인지 정하기 위한 클래스이다.

|함수|파라미터|반환 값| 설명                            |
|---|---|---|-------------------------------|
|`generate`|`Unit`|`Int`| 클래스 내에 정의된 범위가 적용된 랜덤한 정수를 반환 |

### 🚨 Exception

---

## 🛸 InputView

|함수|파라미터| 반환 값   | 설명                                 |
|---|---|--------|------------------------------------|
|`readLineAbout`|`RequestType`| `String` | `RequestType`에 대해 적절한 함수로의 입력을 수행한다. |

### 🚨 Exception

---

## 🛸 OutputView

|함수| 파라미터     | 반환 값   | 설명                                 |
|---|----------|--------|------------------------------------|
|`printGuidMessage`| `String` | `Unit` | 안내 메시지를 출력해야 하는 경우, 이 함수를 통해 출력한다. |
|`printMap`| `String` | `Unit` | 진행 상황을 출력해야 하는 경우, 이 함수를 통해 출력한다.  |
|`printResult`| `String` | `Unit` | 결과를 출력해야 하는 경우, 이 함수를 통해 출력한다.     |
|`log`| `String`   | `Unit`   | 에러 메시지를 출력해야 하는 경우, 이 함수를 통해 출력한다. |

### 🚨 Exception

---

## 📁 ResponsePacket.kt

### ResponsePacket
`BridgeGame` 클래스가 `Application`과 정보를 주고 받을 수 있도록 돕는 데이터 클래스이다.

### ResponsePacketFor
`Application`의 `main` 함수가 `BridgeGame` 클래스와 정보를 주고 받을 수 있도록 돕는 클래스이다.

### 🚨 Exception

