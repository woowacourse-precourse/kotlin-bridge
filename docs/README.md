# 다리 건너기

## 기능목록
- [✅] 입력받은 길이의 다리를 생성할 수 있다.
- [✅] 이동한 칸 상태를 다리에 표시 할 수 있다.
- [✅] 현재 까지 진행한 다리를 출력 할 수 있다.
- [ ] 건너다 실패하면 재시작할 수 있다.

---

## 구성요소  

### Domain

- BrideGame
- BridgeMaker
- BridgeNumberGenerator
- BrideGameController

### Data

- Bridge
- GameResult

### UI

- InputView
- OutputView

### Exception

- ExceptionHandler


---  


## 체크리스트  

- [ ] 다리 길이를 숫자로 입력 받았는가?
- [ ] 0인 경우 아래칸 1인 경우 위칸이 건널수 있는 칸으로 했는가? 
- [ ] 건널수 있는경우 값을 U 와 D 로 표현 했는가?
- [ ] 대문자로 입력 받았는가?
- [ ] 에러 를 명확한 유형으로 처리 했는가?
- [ ] 입력 이 올바른 값이 아니면 예외처리 했는가?
- [ ] 함수의 길이가 10라인을 넘어가지 않는가?**(메인포함)**
- [ ] 메서드 파라미터는 3개 이하 인가?
- [ ] 클래스 요구사항을 잘 지켰는가?
- [ ] BridgeGame 클래스에서 InputView 클래스와 OutputView  클래스를 사용하지 않았는가?
- [ ] 주어진 OutputView 메서드의 이름, 인자와 반환 타입을 변경하지 않았는가?
- [ ] 주어진 BridgeMaker 에서 필드 나 시그니처(인자,이름), 반환 타입은 변경하지 않았는가?

