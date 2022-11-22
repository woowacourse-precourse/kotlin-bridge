# 미션 - 다리 건너기

## 🛠 ️기능 정의 - Class 별 기능

### InputView

유저 입력을 받는 Class

1. 다리 크기 입력
2. U, D 입력
3. R, Q 입력

### OutputView

다리 게임 출력

### BridgeGame

다리 게임 플레이 Class

### BridgeMaker

다리를 생성하는 class

BridgeRandomNumberGenerator을 통해 U, D 선택하여 다리 크기만큼의 리스트 리턴


### BridgeRandomNumberGenerator

랜덤으로 0,1 반환

### Error

예외처리 담당 class

1. 다리 크기 예외 처리
2. 유저 입력 방향 예외 처리
3. 재시도, 종료 예외처리


## 🛠 ️기능 구현 순서

1. InputView에서 readBridgeSize() 유저 입력 받기
2. BridgeMaker에서 입력 받은 다리의 크기만큼 다리 생성
   1. BridgeRandomNumberGenerator에서 generate() 호출하여
   2. BridgeNumberGenerator에서 generate() 호출하여 다리칸 생성
3. InputView에서 readMoving() 실행하여 BridgeGame실행
4. BridgeGame
   1. prepare(): 입력받은 다리 크기만큼 다리 리스트 생성
   2. playFirst(): 처음 / 재시도 시 다리 게임 첫 실행
   3. move(): 
      - 사용자의 방향 입력 (U/D)로 정답 여부 판별
      - 매 방향 입력마다 display() 다리 게임 현황 출력
   4. retry(): 
      - 재시도 시 --> playFirst() 실행 
      - 종료 시 --> showFinalResult() 실행
5. OutputView 생성
   1. printMapFirst(): 첫 시도시 다리 출력
   2. printMap, printMapLast, printMapBottom, printMapBottomLast(): 다리의 첫 줄과 밑 줄 출력
   3. printResult(): 결과 출력

## ⚠️ ️예외처리
- bridgeSize:
  1. 사용자가 3 ~ 20 범위 밖의 값을 입력했을 때
  2. int가 아닌 값을 입력했을 때

- direction:
  1. U, D 외의 값을 입력했을 때

- retry/quit
  1. R, Q 이 아닌 값을 입력했을 때