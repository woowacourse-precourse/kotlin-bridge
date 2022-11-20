## 🎯 UseCase
### 성공시나리오
1. 시스템이 게임 시작을 알린다.
2. 게임 플레이어가 다리의 길이를 입력한다.
3. 시스템은 다리의 길이에 맞게 다리를 랜덤으로 생성한다.
4. 사용자가 이동할 칸을 선택한다.
5. 시스템은 사용자의 입력이 정답인지 검사한다.
6. 정답일 경우 다리를 다 건널 때까지 4번에서 6번을 반복한다.
7. 오답일 경우 게임을 다시 시도할지 여부를 입력받는다.
8. 사용자가 재시도를 입력할 경우 재시도 횟수를 1증가시키고 다리의 첫번째 스텝부터 시작하여 4번으로 가서 진행한다.
9. 사용자가 게임 종료를 선택할 경우 게임 성공 여부와 최종 게임결과 총시도한 횟수를 출력하고 종료한다.
10. 사용자가 다리를 다 건널 경우 최종 게임 결과와 게임 성공 여부와 총 시도한 횟수를 출력한다.
### 대안시나리오
2a. 사용자가 3~20 범위를 벗어나는 입력을 하는 경우
1. Error Message와 함께 IllegalArgumentException을 throw해준다.

2b. 사용자가 정수를 입력하지 않는 경우
1. Error Message와 함께 IllegalArgumentException을 throw해준다.

4a. 사용자가 U와 D 외의 입력을 하는 경우
1. Error Message와 함께 IllegalArgumentException을 throw해준다.

7a. 사용자가 R과 Q 외의 입력을 하는 경우
1. Error Message와 함께 IllegalArgumentException을 throw해준다.

## 📝기능 구현 리스트
1. startGame - 게임의 시작을 알려주는 기능[O] -  OutputView
2. readBridgeSize - 다리의 길이를 입력 받는 기능[O] - InputView
3. generate - 랜덤 넘버를 생성해주는 기능[O] - BridgeRandoomNumberGenerator에서 주어짐
4. makeBridge - 랜덤 넘버를 받아서 다리를 생성하는 기능[O] - BridgeMaker
5. readMoving - 사용자에게 이동할 칸을 입력받는 기능[O] - InputView
6. compareAnswer - 사용자의 답과 다리를 비교하는 기능[O] - BridgeGame 
7. readGameCommand - 오답일 경우 재시도 여부를 묻고 입력을 받는 기능[O] - InputView
8. printResult - 최종 결과와 게임의 성공 여부와 총 시도한 횟수를 출력하는 기능[O] - OutputView
9. playGame - 게임을 진행하는 기능[ ] - BridgeGameApp
10. printData - 데이터를 출력해주는 기능[O] - OutputView
11. isInt - 입력이 정수인지 판별해주는 기능[O] - Util
12. isInRange - 정수의 범위가 맞는지 판별해주는 기능[O] - Util
13. isUD - 입력이 U/D인지 판별해주는 기능[O] - Util
14. isRQ - 입력이 R/Q인지 판별해주는 기능[O] - Util
15. move - 게임에서 이동을 관장하는 기능[O] - BridgeGame
16. retry - 게임에서 재시작을 관장하는 기능[O] - BridgeGame
17. resultToString - 게임 비교 결과를 스트링으로 변환하는 기능[O] - BridgeGame

## 📦️ 생성 클래스
1. BridgeGame - 게임을 관리하는 클래스
2. BridgeMaker - 브릿지를 생성해주는 클래스
3. BridgeRandoomNumberGenerator - 랜덤한 숫자를 생성해주는 클래스
4. InputView = 입력을 관장하는 클래스
5. OutputView - 출력을 관장하는 클래스
6. Application - 메인 클래스
7. BridgeGameApp - 게임을 실행하는 클래스
8. Util - 예외 처리 클래스
9. Error - 에러 데이터 클래스