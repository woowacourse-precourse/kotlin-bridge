# 기능목록

## Business Logic
- [x] 다리 길이를 입력 받는다
    - [ERROR] 처리 *Validator#isValidBridgeSize()
- [x] 입력 받은 다리의 길이만큼 랜덤 값으로 다리 생성 *BridgeMaker#makeBridge()
  - [x] 랜덤값으로 들어온 0 또는 1 숫자를 `U` 또는 `D` 로 인지하여 변환 *Move#valueOf()
---
- [x] 이동할 칸을 입력 받는다
  - [ERROR] 처리 *Validator#isValidMoving()
- [x] 플레이어가 이동한다. *BridgeGame#move()
  - [x] 플레이어 이동 후, 플레이어가 이동한 상태를 기록 *Player#go()
    - [x] 랜덤다리와 비교하여 플레이어가 건널 수 있는 지 여부 파악 #Player#canGo()
- [x] 현재까지 건넌 다리 모두를 출력한다 *OutputView#pringMap()
- [x] 잘못된 다리 길로 갔을 경우 게임진행 멈춤 *BridgeGame#isFail() > *Player#doNotGo()
  - [ ] 게임 다시 시도 여부 입력 값 입력 받고 유효성 검사
  - [ ] `R` 일 경우, 재시도 로직 구현
  - [ ] `Q` 게임 종료를 원할 경우, 총 결과 출력 시키기 *OutputView#printResult
- [ ] 게임이 종료된 상황일 경우 로직 처리 *BridgeGame#isDone()

## 예외처리
- 입력 받은 다리 길이 유효성 검사
  - [ ] 숫자가 아닐 시 예외처리
  - [ ] 음수일 경우, 문자로 인식하는 지 확인
  - [ ] 부동소수점일 경우, 문자로 인식하는 지 확인
- 입력 받은 이동할 칸 유효성 검사
  - [ ] `U` 와 `D` 가 아닐경우 예외처리
- 입력 받은 게임 다시시도(retry) 입력 값 유효성 검사
  - [ ] `R` 와 `Q` 가 아닐경우 예외처리
