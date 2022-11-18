##기능 목록 (최현지)
* [o] 다리 길이 입력 - InputView
    * 범위 : 3-20
    * 예외처리 필수
* [o] 다리 생성 - BridgeMaker/makeBridge()
    * [o] 랜덤값 - generate()
* [] 플레이어 이동칸 선택 - InputView
    * [o] U or D 입력 가능
    * [] 예외 처리 필수
    * [o] 이동 루트와 다리 비교
* [] 칸 표시 - OutputView
___
CASE 1.
* [] 끝까지 가면 - 게임 종료
* [] 최종 게임 결과 출력 - OutputView
* [] 게임 성공 여부 출력 - OutputView
* [] 시도 횟수 출력 - OutputView
___
CASE 2.
* 실패 - 재시작 or 종료 - InputView
    * [] R or Q 가능
    * 예외 처리 필수
    * [] 재시작 시 다리 재활용 - BridgeGame/retry()
* [] 최종 게임 결과 출력 - OutputView
* [] 게임 성공 여부 출력 - OutputView
* [] 시도 횟수 출력 - OutputView
___
* 잘못된 값 입력시 오류 발생
    * [ERROR] 문 출력 - try-catch 사용
    * 다시 그부분부터 입력