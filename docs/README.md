# 기능 정의
1. 다리 길이 입력받기, IllegalArgumentException 발생 시 에러메시지 출력 후 재입력
- [IllegalArgumentException] 숫자를 입력하지 않은 경우
- [IllegalArgumentException] 3~20 사이의 숫자를 입력하지 않은 경우
2. 다리 생성하기
3. 이동할 칸 입력 받기 (U or D)
- [IllegalArgumentException] U or D를 입력하지 않은 경우
4. 다리 상태 출력하기
- 이동할 수 있는 칸을 선택한 경우 O 표시
- 이동할 수 없는 칸을 선택한 경우 X 표시
- 선택하지 않은 칸은 공백 한 칸으로 표시
- 다리의 시작은 [, 다리의 끝은 ]으로 표시
- 다리 칸의 구분은 | (앞뒤 공백 포함) 문자열로 구분
- 현재까지 건넌 다리를 모두 출력
5. 맞으면 3번으로, 틀리면 재시도 여부 입력 받기 (R or Q), IllegalArgumentException 발생 시 에러메시지 출력 후 재입력
- [IllegalArgumentException] R or Q를 입력하지 않은 경우
6. R을 입력받았을 경우 지금까지 이동 경로 초기화
7. 다시 3번으로
8. 성공 또는 5번에서 Q 입력 시 최종 게임 결과 출력

## InputView
- readBridgeSize : 다리 길이 입력 메서드
- readMoving : 이동할 칸 입력 메서드
- readGameCommand : 게임 재시도 여부 입력 메서드
## OutputView
- printMap : 다리 상태 출력 메서드
- printResult : 게임 최종 결과 출력 메서드
## BridgeMaker
- makeBridge : 다리 생성 메서드
## BridgeGame
- move : 사용자가 칸을 이동할 때 사용하는 메서드
- retry : 사용자가 게임을 다시 시도할 때 사용하는 메서드
