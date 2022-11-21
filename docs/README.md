# 비즈니스 로직 작성
### BridgeGame
- [x] 플레이어가 이동 - move()
- [x] 플레이어가 게임 재시도 - retry()
### BridgeMaker
- [x] 다리의 길이를 입력 받아서 다리를 생성 - makeBridge()
### Bridge
- [x] 다리를 건널 수 있는지 확인 - crossable()
- [x] 다리 크기 - getSize()
### BridgeState
- [x] 다리와 플레이어 입력을 비교 - BridgeState#compare()
- [x] 플레이어 이동을 리스트에 추가하고 반환- BridgeState#insertMove()
### Player
- [x] 게임 플레이 - playGame()
- [X] 다리 건너기 - crossBridge()
# UI 로직 작성
### InputView
- [x] 다리의 길이를 입력 받음 - readBridgeSize()
- [x] 이동할 칸을 입력 받음 - readMoving()
- [x] 게임을 다시 시도할지 입력받음 - readGameCommand()
### OutputView
- [x] 현재까지 이동한 다리의 상태를 출력 - printMap()
- [x] 게임의 최종 결과 출력 - printResult()
- [x] 게임의 성공 여부와 시도 횟수 출력 -printStats()
### Exception
- [x] 공백이나 문자 입력
- [x] 3 ~ 20 숫자가 아닌 입력
- [x] U(위), D(아래) 가 아닌 입력
- [x] R(재시작), Q(종료) 가 아닌 입력
- [ ] 게임이 한번도 실행되지 않아 count 가 0 
### Enum 목록 작성
- [X] Games : 플레이어가 입력한 U, D, R, Q 를 상수로 저장

# 테스트 목록 작성
### BridgeGameTest
- [x] 플레이어 칸 이동 테스트
- [x] 재시도 확인 테스트
### BridgeTest
- [x] 다리 개수 생성 테스트
### InputViewTest
- [x] 21 입력 예외 테스트
- [x] 2 입력 예외 테스트
- [x] 공백 입력 예외 테스트
### OutputViewTest
- [x] 다리 출력 테스트 1
- [x] 다리 출력 테스트 2
- [x] 게임 실행 0회 예외 테스트