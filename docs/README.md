# 미션 - 다리 건너기 기능목록

## 기능 목록

1. 게임 시작 - `play()`
2. 다리 길이 입력 및 다리 생성 - `initializer()`
   1. 게임 시작 메시지 출력 - `printStart()`
   2. 다리 길이 입력 - `retryReadBridgeSize()`
      1. 숫자 여부
      2. 범위 3 ~ 20 일치 여부
   3. 다리 생성 - `makeBridge()`
3. 게임 진행 및 정답 여부 리턴 - `playGame()`
   1. 이동 입력 - `retryReadBridge()`
      1. U or D 여부
   2. 정답 여부 - `move()`
4. 게임 진행 반복 및 정지 여부 결정  - `playGameLoop()`
   1. 진행 상황 출력 - `printMap()`
   2. 정답 여부 판단. 틀릴 경우 혹은 다리 끝까지 갔을 경우 정지 - `escape()`
5. 게임 재시작 혹은 종료 판단. 끝까지 갔을 경우 판단 없이 종료 - `judgeGameEnd()`
   1. 재시작 판단 - `retry()`
6. 최종 결과 출력 - `printResult()`

## 패키지 구조

bridge
- controller 
    - BridgeGameController 
- domain
    - BridgeGame
    - BridgeMaker
    - InputView
- enums
    - GameMessages
    - Status
- ui
    - OutputView
- util
    - BridgeNumberGenerator
    - BridgeRandomNumberGenerator
Application.kt

## 기능 요구 사항

- 위아래 두 칸으로 이루어진 다리를 건너야 한다.
  - 다리는 왼쪽에서 오른쪽으로 건너야 한다.
  - 위아래 둘 중 하나의 칸만 건널 수 있다.
- 다리의 길이를 숫자로 입력 받고 생성한다.
  - 다리를 생성할 때 위 칸과 아래 칸 중 건널 수 있는 칸은 Random 값을 이용해서 정한다.
  - 위 칸을 건널 수 있는 경우 U, 아래 칸을 건널 수 있는 경우 D 값으로 나타낸다.
  - Random 값이 0인 경우 아래칸, 1인 경우 위 칸이 건널 수 있는 칸이 된다.
- 다리가 생성되면 플레이어가 이동할 칸을 선택한다.
  - 이동할 때 위 칸은 대문자 U, 아래 칸은 대문자 D를 입력한다.
  - 이동한 칸을 건널 수 있다면 0로 표시한다. 건널 수 없다면 X로 표시한다.
- 다리를 끝까지 건너면 게임이 종료된다.
- 다리를 건너다 실패하면 게임을 재시작하거나 종료할 수 있다.
  - 재시작해도 처음에 만든 다리로 재사용한다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
    - `Exception`이 아닌 `IllegalArgumentException`, `IllegalStateException` 등과 같은 명확한 유형을 처리한다.

## 프로그래밍 요구 사항

- [ ] kotlin 코드 컨벤션 준수
- [ ] 프로그래밍 요구 사항에서 명시하지 않는 한 파일, 패키지 이름 수정하거나 이동 X
- [ ] indent는 2까지만 허용
- [ ] 함수가 한 가지 일만 하도록 구현
- [ ] else를 지양
- [ ] 도메인 로직 단위 테스트 구현
- [ ] 핵심 로직과 UI 로직 분리

## 추가 요구 사항

- [ ] 함수의 길이 10이하
- [ ] 메서드 파라미터 개수 3이하
- [ ] `InputView`, `OutputView`, `BridgeGame`, `BridgeMaker` 클래스의 요구사항을 참고하여 구현
  - [ ] `InputView` 클래스에서만 `readLine()` 메서드 이용
  - [ ] `BridgeGame` 클래스에서 `InputView`, `OutputView` 사용 X

### InputView 클래스

- 제약 사항 없음

### OutputView 클래스

- [ ] 메서드 이름 변경 X

### BridgeGame 클래스

- 제약 사항 없음

### BridgeMaker 클래스

- [ ] 필드 변경 X
- [ ] 메서드 시그니처, 반환 타입 변경 X

### BridgeRandomNumberGenerator

- [ ] 코드 및 패키지 변경 X

## 3주 차 공통 피드백

- [ ] `main()`도 함수길이 맞출 것
- [ ] 발생할 수 있는 모든 예외상황 작성
- [ ] 비즈니스 로직, UI 로직 분리
- [ ] 연관성 있는 상수는 enum을 활용
- [ ] val 키워드로 값 변경 막기
- [ ] 객체 상태 접근 제한
- [ ] 객체에서 데이터를 꺼내지 말고(get) 메시지를 던지도록 구조를 짤 것
- [ ] 필드의 수를 줄이기 위해 노력
- [ ] 예외에 대한 케이스 테스트(경계값)
- [ ] 테스트 코드도 리팩터링
- [ ] 테스트를 위해 접근제어자 수정 X
- [ ] 테스트가 힘들 경우 외부로 분리
- [ ] private 함수 테스트 시 객체 분리

## 3주 차 피어리뷰 피드백
- [ ] 함수 주석은 오픈소스 용이므로 작성 X
- [ ] 변수명이 확실하면 줄일 것
- [ ] domain 내부 패키지 분리
- [ ] 코드가 한 줄일 경우 `=`로 처리
- [ ] 컨트롤러 작성
- [ ] dto와 domain 분리
- [ ] 예외 처리 시 require 이용

