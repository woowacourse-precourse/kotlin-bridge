# ★ 미션 - 다리건너기 ★
#### 위아래 둘 중 하나의 칸만 건널 수 있는 다리를 끝까지 건너가는 게임
#### todayis-sunny

---

- 위 아래 두칸으루 이루어진 다리
  - 왼쪽 >> 오른쪽
  - 위 아래 둘 중 한칸
- 다리 길이 입력
  - 건널 수 있는 칸 : 위 칸 아래 칸 0과 1
  - 위 칸 : U, 아래 칸 : D 나타냄
- 생성 후 플레이어 이동
  - 위 칸 : U, 아래 칸 : D 입력 
  - 건널 수 있다면 : O, 건널 수 없다면 : X
- 다리 완주시 게임종료
  - 실패시 게임 재시작 or 종료
  - 총 시도한 횟수는 첫 시도 부터 계산
- 사용자가 잘못된 값 입력 : `IllegalArgumetException`발생 "[EROOR]"로 시작하는 에러 메시지 출력 후 다시 입력
  - `Exception`이 아닌 명확한 유형을 처리
## ▶ 기능 순서
```
01. <출력> 다리 건너기 게임을 시작
02. <출력> 다리의 길이 입력
03. <입력> 3 이상 20이하의 숫자
04. <출력> 이동할 칸을 선택
05. <입력> 위 : U, 아래 : D
06. <출력>  
    [ O |   ] 이동 가능 칸 : O
    [   | X ] 이동 불가 칸 : X
07. <출력> 다시 시도
08. <입력> 재시도 : R, 종료 : Q
    (1). 재시도 : R => [04]
    (2). 종료 : Q => [09]
09. <출력>
    게임 성공 여부: 성공/실패
    총 시도한 횟수: N
```
---
## ▶ 기능 목록
### `InputView` _클래스_
- [x] `readBridgeSize` : 다리 길이 입력
- [x] `readMovig` : 사용자가 이동할 칸 입력
- [x] `readGameCommand` : 게임 재시작 여부 입력

### `OutputView` _클래스_
- [x] `printMap` : 현재까지 이동한 다리 상태 출력
- [x] `printResult` : 게임의 최종 결과 출력
- [x] `printGameStart` : 게임 시작 출력
- [x] `printBridgeLength` : 길이 입력 출력
- [x] `printSelectMoveToSpace` : 이동할 칸 선택 출력

### `BridgeGame` _클래스_
- [x] `move` : 이동
- [x] `retry` : 재시작

### `BridgeMarker` _클래스_
- [x] `makeBridge` : 입력받은 길이에 해당하는 다리모양

### `Bridge` _클래스_
- [x] `addUserBrdige` : 움직일 칸을 입력받아 사용자 다리에 추가
- [x] `bridgeComparison` : 사용자 다리와 컴퓨터 다리 비교
---
## ▶ 프로그래밍 요구 사항
- [x] `ApplicationTest`의 모든 테스트 성공
- [x] indent depth를 3이 넘지 않도록 구현
- [x] 함수가 한 가지 일
- [x] 기능 테스트
- [x] else를 지양
#### 추가된 요구 사항
- [x] 함수 최대 길이 10라인
- [x] 메서드의 파라미터 최대 3개
- [x] 각 클래스 요구사항 참고 구현
    - [x] `InputView` 클래스에서만 `readLine()` 메서드를 이용하여 입력
    - [x] `BridgeGame` 클래스에서 `InputView`, `OutputView` 사용금지
