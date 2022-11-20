# 기능 목록 작성
### BridgeGame
- [ ] 사용자가 이동 - move()
- [ ] 사용자가 게임 재시도 - retry()
### BridgeMaker
- [ ] 다리의 길이를 입력 받아서 다리를 생성 - makeBridge()
### BridgeState
- [ ] 다리와 사용자 입력을 비교 - BridgeState#compare()
### Player
- [ ] 플레이어가 다음 칸으로 점프 - jump()
- [ ] 플레이어가 살았는가 - isAlive()
### InputView
- [ ] 다리의 길이를 입력 받음 - readBridgeSize()
- [ ] 이동할 칸을 입력 받음 - readMoving()
- [ ] 게임을 다시 시도할지 입력받음 - readGameCommand()
### OutputView
- [ ] 현재까지 이동한 다리의 상태를 출력 - printMap()
- [ ] 게임의 최종 결과 출력 - printResult()
### Exception
- [ ] 사용자 공백 입력
- [ ] 3 ~ 20 숫자가 아닌 입력
- [ ] U(위), D(아래) 가 아닌 입력
- [ ] R(재시작), Q(종료) 가 아닌 입력
