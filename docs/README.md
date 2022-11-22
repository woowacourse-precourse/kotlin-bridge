## ✅ 기능 목록
1. InputView 클래스
- readBridgeSize: 다리의 길이를 입력받는 함수 - String으로 입력받음  
- checkBridgeSizeException: 입력받은 다리의 길이가 잘못됐을 경우(숫자가 아니거나 범위를 벗어난 숫자를 입력받았을 경우) 예외 발생  
- checkDigit: 다리 길이 예외처리 함수에서 입력받은 다리 길이가 숫자인지 아닌지 판별   
- readMoving: 사용자가 이동할 칸을 입력받는 함수   
- checkMovingInputException: 사용자가 이동할 칸을 U나 D 외의 문자로 입력했을 경우 예외 발생  
- readGameCommand: 사용자가 게임을 다시 시작할지 여부를 입력받음  
- checkGameCommandException: 사용자가 게임 재시작 여부를 R이나 Q 외의 문자로 입력했을 경우 예외 발생   

2. BridgeGame 클래스
- move: 사용자가 올바른 다리를 건너는 경우 다리 모양 변화. 사용자가 정답을 맞힌 횟수(=bridgeNumber, 존재하는 다리의 개수)에 따라 다르게 동작한다.  
- moveLose: 사용자가 틀린 다리를 입력한 경우 다리 모양 변화  
- checkWinLose: 다리에 X가 있는 경우를 판별해 게임의 승패를 체크함  
- retry: 답을 틀리기 전인 다리 모양으로 현재 다리 모양을 바꿈  

3. BridgeMaker 클래스
- makeBridge: 사용자에게 입력받은 다리 길이대로 정답 다리 방향 리스트인 answerBridge 생성  

4. OutputView 클래스
- printMap: 정해진 형식대로 다리 출력  
- printResult: 정해진 형식대로 최종 결과 출력

5. Application.kt
- getBridgeSize: 초기 문구 출력, 다리 길이 입력받고 예외 체크까지 함  
- getMoving: 사용자에게 이동 방향을 입력받고 예외 체크를 함  
- correctMove: 사용자가 올바른 방향을 입력했을 경우 다리를 이동하고 출력시킴  
- wrongMove: 사용자가 틀린 방향을 입력했을 경우 다리를 변형시키고 출력시킴  
- getGameCommand: 실패 시 재시도 여부를 입력받고 예외 체크를 함
