각 클래스 기능 구현 목표
BridegeGame:
1. 입력한 다리 칸(U, D)에 따라 이동하는 조건 생성
2. 입력한 재시작 여부(R, Q)에 따라 재시작 조건 생성

** BridgeMaker:
1. InputView에서 입력받은 다리길이만큼 bridge에 해당하는 리스트 생성
2. bridge에 해당하는 리스트의 랜덤값은 BridgeNumberGenerator, BridgeRandomNumberGenerator가 관여
3. InputView나 OutputView를 호출하지 않음 -> main으로 반환해서 BridgeMaker로 넘겨야한다.

** InputView:
1. 다리길이 입력, 내딛을 다리 칸(U, D) 입력, 재시작 여부(R, Q) 입력
2. 올바른 값이 입력되지 않았을 경우 오류 검출

** OutputView:
1. 각 클래스의 기능을 이용하여 입력에 따른 결과물을 반환없이 print한다.

** Application(main함수):
1. 각각의 모듈화된 클래스를 메인함수에서 실행하게 한다