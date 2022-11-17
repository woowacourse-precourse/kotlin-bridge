# 🔧 구현 기능 목록

--- 

## 🚀 Application.kt

### 🚨 Exception

---  

## 🚀 BridgeGame 클래스
`BridgeGame` 클래스는 BridgeGame을 관리하는 클래스이다.
`BridgeGame` 클래스는 요청(request)을 받는다면 그에 해당하는 응답(response)을 하도록 한다.

|함수|파라미터| 반환 값    | 설명                                           |
|---|---|---------|----------------------------------------------|
|request|Enum| Boolean | 지정된 request 요청에 맞는 함수를 실행하고 게임 상태를 update한다. 요청이 제대로 수행되었다면 true를, 수행되지 않았다면 false를 반환한다|

- 사용 예시
```kotlin

val brideGame: BrideGame = BridgeGame()
var nowState: String = ""

//...

if (brideGame.request(BridgeGame.MOVE, "U") == false) {
    // [ERROR]
}
nowState = brideGame.request(BridgeGame.MASSAGE)
print(nowState)
```
- 출력
```kotlin
[ O ]
[   ]

이동할 칸을 선택해주세요. (위: U, 아래: D)
```


### 🚨 Exception

---  

## 🚀 BridgeMaker 클래스

|함수|파라미터|반환 값|설명|
|---|---|---|---|
|`makeBridge`|`Int`|`List<String>`|`makeBridge` 함수는 다리 길이를 파라미터로 전달 받아 해당 하는 다리 모양을 만들어 반환한다. 위 칸이면 "U", 아래 칸이면 "D"로 표현된다.|

### 🚨 Exception
makeBridge 함수는 단순히 요청 받은 size에 대한 다리를 생성하여 반환한다. 이 size에 대하여 예외 사항이 있다면 makeBride 함수를 요청한 쪽에서 처리하도록 한다.

---

## 🚀 BridgeRandomNumberGenerator 클레스
`BridgeRandomNumberGenerator` 클래스는 `BridgeNumberGenerator` 인터페이스를 상속받아 구현된다.
다리를 생성할 때 U형과 D형을 정하기 위한 클래스이다.

|함수|파라미터|반환 값| 설명                            |
|---|---|---|-------------------------------|
|`generate`|`Unit`|`Int`| 클래스 내에 정의된 범위가 적용된 랜덤한 정수를 반환 |

### 🚨 Exception

---

## 🚀 InputView 클래스

|함수|파라미터|반환 값|설명|
|---|---|---|---|

### 🚨 Exception

---

## 🚀 OutputView 클래스

|함수|파라미터|반환 값|설명|
|---|---|---|---|

### 🚨 Exception

---

## 🚀 NextMyClass 클래스

|함수|파라미터|반환 값|설명|
|---|---|---|---|

### 🚨 Exception

