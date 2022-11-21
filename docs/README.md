# 🚀 구현할 기능 목록

## Application.kt

- [ ] 게임 진행 play 메서드 추가

## BridgeGame.kt

- [ ] move : 다리 이동 기능 메서드
- [ ] retry : 게임 다시 시작 기능 메서드

## BridgeMaker.kt

- [ ] 0과 1에 해당하는 상수 추가
- [ ] makeBridge 메서드에서 BridgeNumberGenerator의 generate 메서드를 사용해서 bridge 리스트를 생성해서 반환

## InputView.kt

- [ ] readBridgeSize : 다리의 크기 bridgeSize를 입력 받음
- [ ] readMoving : 사용자의 moving을 입력 받음
- [ ] readGameCommand : 게임을 시작할지 말지 정할 gameCommand 입력 받음

## OutputView.kt

- [ ] printMap을 통해 다리 출력
- [ ] printResult를 통해 게임 결과 출력

## InputErrorCheck.kt

- [ ] readBridgeSize : 숫자가 아닌 경우 예외처리 메서드 추가
- [ ] readBridgeSize : 3 이상 20 이하가 아닌 숫자를 입력하는 경우 예외처리 메서드 추가
- [ ] readMoving : U 또는 D가 아닌 경우 예외처리 메서드 추가
- [ ] readGameCommand : R 또는 Q가 아닌 경우 예외처리 메서드 추가


# 🚨 추가된 프로그래밍 요구 사항

### * [Kotlin 코드 컨벤션](https://kotlinlang.org/docs/coding-conventions.html)

### * 함수(또는 메서드)의 길이가 10라인을 넘어가지 않도록 구현한다.
- 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.

### * 메서드의 파라미터 개수는 최대 3개까지만 허용한다.

### * 아래 있는 InputView, OutputView, BridgeGame, BridgeMaker 클래스의 요구사항을 참고하여 구현한다.
- 각 클래스의 제약 사항은 아래 클래스별 세부 설명을 참고한다.
- 이외 필요한 클래스(또는 객체)와 메서드는 자유롭게 구현할 수 있다.
- InputView 클래스에서만 `camp.nextstep.edu.missionutils.Console` 의 `readLine()` 메서드를 이용해 사용자의 입력을 받을 수 있다.
- BridgeGame 클래스에서 InputView, OutputView 를 사용하지 않는다.

### * camp.nextstep.edu.missionutils에서 제공하는 Console API를 사용하여 구현해야 한다.
- 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.