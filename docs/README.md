# 1. 어떠한 게임인가?

길이가 3~20 내로 사용자에게 입력을 받고, 그 입력에 따라 두개의 길을 생성한다

생성된 두 개의 길, 대충 요구사항에 맞춰서 U와 D라고 하자. 이 U와 D의 길은 한 칸은 정답이오, 한 칸은 떨어지는 오답이다.

이 두 개의 길을 맞춰가며 끝까지 도달하면 끝나는 게임이다.

ex) 정답이
>O O X <p>
>X X O 

일때, U를 먼저 두 번, D 한 번이면 통과, 이외는 실패처리.

이 때 출력은
```aidl
[ O | O |   ]
[   |   | O ]
```
이며, 만약 U, D로 해서 실패했을 경우는 아래와 같다.

```aidl
[ O |   ]
[   | X ]
```
이 때 총 시도한 횟수를 기록하여 마지막에 출력하도록 한다.

# 2. 구성을 어떻게 하여야하는가?

## 기본 구성

### 흐름제어

- `BridgeGame` : 전체적인 게임의 흐름을 담당한다.

    >`InputView`과 `OutputView`의 직접 출력 불가.
- `BridgeMaker` : 게임의 요점인 다리를 만든다.

### 계산영역

- `BridgeNumberGenerator` : 다리를 만드는 기초공사. 
- `BridgeRandomNumberGenerator` : 0과 1 둘 중 하나를 반환한다.
    >다만, `BridgeNumberGenerator`와 `BridgeRandomNumberGenerator`의 수정은 불가. <br>기능적으로 완성되어있으니 문제는 없다.


### 입출력

- `OutputView` : 출력할 것들을 담당한다.
- `InputView` : 여러가지 값을 사용자로부터 입력받는다.

## 추가 구성

### 흐름제어

- `BridgeGameManager` : 전체적인 흐름관리.
- `BridgeException` : 예외처리에 관한 함수들. 흐름제어가 아니라 계산영역인가?
- 추후 추가될 수도 있음.

### 계산영역

- `BridgeCalculate` : 온갖 계산에 대한 오브젝트.

### 입출력

- `BridgeParameter` : enum class로 여러가지 값을 저장한다.
- `BridgeMessage` : enum class로 여러가지 문장을 저장한다.



## 구현순서

### 1. 사이즈 입력에 대한 구현

  - 사이즈 입력에 대한 예외처리도 구현

### 2. 사이즈 입력에 대응해 다리 생성에 대한 구현

### 3. 이동에 대한 구현

  - 이동의 예외처리도 구현
  - 이동 후 나오는 맵 생성 구현
  - 성공/실패 시 처리에 대하여 구현
  - 재시도에 관한 구현
  - 최종 성공 후 출력에 관한 구현

## 위 구현 들이 끝나고 수정한 사항들

- [x] BridgeMaker의 makeBridge의 일부분을 사양서대로 수정
- [x] 위와 연관된 사항들 수정
- [x] BridgeGame에서 Input/OutputView 제거
- [x] 단위 로직 테스트 만들기? 1개만 만들어서 애매?



