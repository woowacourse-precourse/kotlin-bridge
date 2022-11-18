##다리 건너기 기능 명세서

###Model 기능 명세서
- `BridgeBoard`
  - 최신상태의 진행 상황을 유지한다


###View 기능 명세서
- `InputView`
  - 다리 길이를 입력받음
  - 플레이어가 이동할 칸을 입력받음
  - 게임 재시작 여부를 입력받음
  
- `OutputView`
  - 게임 시작 문구를 출력함
  - 이동할 때마다 다리 건너기 결과를 출력함
  - 게임 종료 문구를 출력함


###Controller 기능 명세서
- `BridgeGame`
  - user 를 한칸 이동시킴
  - 게임을 다시 시작함
  - Model 에 move 의 결과를 업데이트를 명령함
  - View 에  업데이트 된 Model 의 출력을 명령함


###Utils 기능 명세서
- `BridgeMaker`
  - 다리를 생성함
- `BridgeRandomNumberGenerator`
  - 윗칸과 아랫칸 중 건널 수 있는 칸을 랜덤하게 생성함
###예외처리
- 입력된 다리 길이가 3 이상 20 이하의 수가 아닐 때
- 입력된 이동할 칸이 U나 D가 아닐 때
- 입력된 재시작 여부가 R이나 Q가 아닐 때