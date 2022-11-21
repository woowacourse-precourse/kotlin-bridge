# 미션 - 다리 건너기

## 🛠 ️기능 정의 - Class 별 기능

### InputView

유저 입력을 받는 Class

1. 다리 크기 입력
2. U, D 입력
3. R, Q 입력

### OutputView

### BridgeGame

### BridgeMaker

### BridgeRandomNumberGenerator


## 🛠 ️기능 구현 순서

1. InputView에서 readBridgeSize() 유저 입력 받기
2. BridgeMaker에서 입력 받은 다리의 크기만큼 다리 생성
   1. BridgeRandomNumberGenerator에서 generate() 호출하여
   2. BridgeNumberGenerator에서 generate() 호출하여 다리칸 생성
3. OutputView 생성
4. InputView에서 readMoving() 실행하여 BridgeGame실행