# 다리 건너기 게임

## 기능 목록
-[ ] 다리 건너기 게임을 시작한다. - start()#Application
-[ ] 다리 세팅후 게임을 진행한다. - play()#Application
-[ ] 다리의 길이를 숫자로 입력받는다. - readBridgeSize()#InputView
-[ ] 입력받은 길이만큼 다리를 생성한다. - makeBridge()#BridgeMaker
    -[ ] 다리를 생성할 때 위 칸과 아래 칸중 건널 수 있는 칸을 정한다. - generate()#BridgeRandomNumberGenerator : BridgeNumberGenerator
    -[ ] 건널 수 있는 칸을 정할 때는 Random 값을 이용해서 정한다.
    -[ ] Random 값이 0인 경우 아래칸, 1인 경우 위 칸이 건널 수 있는 칸이 된다.
    -[ ] 위 칸을 건널 수 있는 경우 U 값을 나타낸다. - representBridge()#BridgeMaker
    -[ ] 아래 칸을 건널 수 있는 경우 D 값을 나타낸다. - representBridge()#BridgeMaker
    -[ ] 다리는 게임을 종료하기 전까지 계속해서 사용된다.
-[ ] 다리가 생성되면 플레이어가 이동할 칸을 입력받는다. - readMoving#InputView
    -[ ] 이동할 때 위 칸은 대문자 U를 입력한다. - move()#BridgeGame
    -[ ] 이동할 때 아래 칸은 대문자 D를 입력한다. - move()#BridgeGame
    -[ ] 이동한 칸을 건널 수 있다면 O로 표시한다. - moveCheck()#BridgeGame
    -[ ] 건널 수 없다면 X로 표시한다. - moveCheck()#BridgeGame
-[ ] 다리를 끝까지 건너면 게임이 종료된다. - printResult()#OutputView
-[ ] 다리를 건너다 실패하면 게임을 재시작하거나 종료할 수 있다. - retry()#BridgeGame
    -[ ] 게임을 재시작하러면 대문자 R을 입력받는다. - readGameCommand()#InputView
    -[ ] 게임을 종료하려면 대문자 Q를 입력받는다. - readGameCommand()#InputView
-[ ] 예외 처리 함수 #Exception
-[ ] 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException를 발생시킨다.
-[ ] 사용자가 잘못된 값을 입력할 경우 "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
-[ ] 상수 값 #Constant

## 기능 요구 사항
- 위아래 두 칸으로 이루어진 다리를 건너야 한다.
    - 다리는 왼쪽에서 오른쪽으로 건너야 한다.
    - 위아래 둘 중 하나의 칸만 건널 수 있다.
- 다리의 길이를 숫자로 입력 받고 생성한다.
    - 다리를 생성할 때 위 칸과 아래 칸 중 건널 수 있는 칸은 Random 값을 이용해서 정한다.
    - 위 칸을 건널 수 있는 경우 U, 아래 칸을 건널 수 있는 경우 D 값으로 나타낸다.
    - Random 값이 0인 경우 아래 칸, 1인 경우 위 칸이 건널 수 있는 칸이 된다.
- 다리가 생성되면 플레이어가 이동할 칸을 선택한다.
    - 이동할 때 위 칸은 대문자 U, 아래 칸은 대문자 D를 입력한다.
    - 이동한 칸을 건널 수 있다면 O로 표시한다. 건널 수 없다면 X로 표시한다.
- 다리를 끝까지 건너면 게임이 종료된다.
- 다리를 건너다 실패하면 게임을 재시작하거나 종료할 수 있다.
    - 재시작해도 처음에 만든 다리로 재사용한다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
    - Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.

