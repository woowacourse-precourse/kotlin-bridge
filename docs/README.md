# 미션 프로세스
1. 게임 시작 문구를 출력한다
2. 생성할 다리 길이를 입력 받는 문구를 출력한다
3. 다리 길이를 입력 받는다
4. 입력이 올바른지 확인한다 -> 실패시 다시 입력 받는다(최대 3회로 제한하기)
5. 다리를 생성한다
6. 이동할 칸을 입력 받는 문구를 출력한다
7. 입력이 올바른지 확인한다 -> 실패시 다시 입력 받는다(최대 3회로 제한하기)
8. 이동한 결과를 출력한다 -> 실패시 재시도 문구를 출력한다
9. 재시도 입력 혹은 이동 입력을 받는다 -> 종료를 선택할 시 결과를 출력한다
10. 6-9 과정을 반복한다 -> 성공 결과를 출력한다

# 클래스별 기능목록
각 클래스가 어떤 기능을 담당하는지, 세부 함수와 변수를 정리

## InputView
클래스 기능 요약: 사용자로부터 입력을 받고 검증하는 과정을 담당

### Method 목록
- readBridgeSize(): 다리 길이를 입력하는 함수
- readMoving(): 사용자가 이동할 칸을 입력하는 함수
- readGameCommand(): 사용자가 게임을 다시 시도할지 종료할지 여부를 입력하는 함수
- lengthChecker(): 입력받은 문자열이 허용 입력 길이를 초과했는지 확인하는 함수, 초과되었을 경우 오류 출력
- numberChecker(): 입력받은 문자열이 숫자인지 확인하는 함수, 숫자가 아닌 경우 오류 출력
- stringChecker(): 입력받은 문자열이 숫자인지 확인하는 함수, 숫자인 경우 오류 출력
- numberRangeChecker(): 입력받은 문자열이 허용 범위 이내의 숫자인지 확인하는 함수, 초과된 입력이면 오류 출력
- stringRangeChecker(): 입력받은 문자가 허용 범위 이내의 재시작 혹은 이동 문자인지 확인하는 함수, 허용되는 문자가 아닌 경우 오류 출력

### companion object
출력 문구와 허용범위에 대한 변수 지정
- MIN_BRIDGE_SIZE: 최소 다리 길이
- MAX_BRIDGE_SIZE: 최대 다리 길이
- COMMAND_UP: 위쪽 입력 커맨드
- COMMAND_DOWN: 아래쪽 입력 커맨드
- COMMAND_RESTART: 재시작 입력 커맨드
- COMMAND_QUIT: 종료 입력 커맨드
- NOT_ALLOWED_...: error 문구
- COMMAND_RANGE: 허용 재시작 커맨드 리스트
- MOVING_RANGE: 허용 이동 커맨드 리스트

## OutputView
클래스 기능 요약: 입력에 대한 결과를 출력하는 과정을 담당

### Method 목록
- printMap(): 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력
- printResult(): 게임의 최종 결과를 정해진 형식에 맞춰 출력
- printBridge(): 다리 길이 입력 문구 출력
- printMove(): 이동할 칸 입력 문구 출력
- printRetry(): 재시도 문구 출력
- printTryNumber(): 총 시도 횟수 출력

### companion object
출력 문구에 관련된 문자열 관리
- PRINT_...: 각종 입력 이벤트 발생전 알려주는 문구
- SEP: 구분자

## BridgeGame
클래스 기능 요약: 이동과 재시도등 게임 진행 과정을 담당

### Method 목록
- move(): 사용자가 칸을 이동할 때 사용하는 함수
- retry(): 사용자가 게임을 다시 시도할 때 사용하는 함수
- moveNextBridge(): 사용자의 입력에 따라 상태를 저장하는 함수
- getUpBridge(): upBridge 배열 가져오는 함수
- getDownBridge(): downBridge 배열 가져오는 함수
- getRetryCounter(): retryCounter 값 가져오는 함수
- getIsContinue(): isContinue 값 가져오는 함수

### companion object
현재까지의 결과 저장을 위한 문자열 관리
- MOVE_CORRECT: 이동에 성공했을 때 저장하는 변수
- MOVE_WRONG: 이동에 실패했을 때 저장하는 변수
- MOVE_INIT: 초기값 지정을 위한 변수

### Field 목록
- bridgeSize: 다리 길이 상수 변수
- retryCounter: 재시도 횟수 저장하는 상수 변수
- isContinue: 게임 실패, 성공 여부를 저장하는 불린 변수
- upBridge: 현재까지 진행상황 중 "U" 입력에 대한 정보를 저장하는 배열 변수
- downBridge: 현재까지 진행상황 중 "D" 입력에 대한 정보를 저장하는 배열 변수

## BridgeMaker
클래스 기능 요약: 다리를 생성하는 부분을 담당

### Method 목록
- makeBridge(): 다리의 길이를 입력 받아서 다리를 생성해주는 함수

## BridgeRandomNumberGenerator
클래스 기능 요약: 다리를 생성하기 위한 난수 생성을 담당
- generate(): 0 또는 1을 무작위로 반환하는 함수

## BridgeManager
클래스 기능 요약: 게임을 진행하는 과정을 총괄하는 클래스

### Method 목록
- setBridgeSize(): 다리 길이를 입력받는 함수
- getMoveCommand(): 다리 이동 입력받는 함수
- moveBridge(): 사용자의 입력으로부터 다리 이동을 적용하는 함수
- retryChecker(): 사용자의 다리 이동 실패 후 재시작을 확인하는 함수
- restartGame(): 사용자의 재시작을 적용하는 함수
- getRetryCommand(): 사용자의 재시작 입력받는 함수
- printGameResult(): 게임 결과를 출력하는 함수
- gameLoop(): 게임을 진행하는 함수

### Field 목록
- inputView: InputView 클래스 인스턴스
- outputView: OutputView 클래스 인스턴스
- bridgeSize: 다리 길이 상수 변수
- bridge: 다리 리스트
- bridgeGame: BridgeGame 클래스 인스턴스
- position: 현재까지 진행된 인덱스 상수 변수
