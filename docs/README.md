# Function Specification 🚀

### 게임 시작
- [x] 게임 시작 문구를 출력한다.
- [x] 다리의 길이를 숫자로 입력받는다.
  - [x] `3` 이상 `20` 이하의 값을 입력받고, 올바른 값이 아니면 예외처리 한다.
- [x] `0`은 아래칸, `1`은 위칸으로 해서 건널 수 있는 무작위 다리를 생성한다.

###  게임 진행
- [x] 다리가 생성되면 매 라운드마다 플레이어에게 이동할 칸을 입력받는다.
  - [x] 이동할 때 위 칸은 `U`, 아래 칸은 `D`를 입력받고, 올바른 값이 아니면 예외처리 한다.
- [x] 이동한 칸을 건널 수 있다면 `O`을, 건널 수 없다면 `X`를 표시한다.

### 게임 종료
- [x] 다리를 끝까지 건너면 게임이 종료된다.
- [x] 다리를 건너다 실패하면 게임을 재시작하거나 종료할 수 있다.
  - [x] 재시작은 `R`, 종료는 `Q`를 입력받고, 올바른 값이 아니면 예외처리 한다.
  - [x] 재시작해도 처음에 만든 다리 정보를 재사용한다.
  - [x] Q를 누르면 게임을 완전히 종료한다.
- [x] 게임이 종료되면 `최종 게임 결과`와 `게임 성공여부`, `총 시도한 횟수`를 출력한다.

### 예외 상황
- [x] 잘못된 입력값에 대해 `IllegalArgumentException`를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.

---
# Implementation 🎲

---
# Test 🔧

---
# Convention ❄️
- [코틀린 코딩 컨벤션](https://kotlinlang.org/docs/coding-conventions.html#properties)
- [코틀린 스타일 가이드](https://developer.android.com/kotlin/style-guide?hl=ko)
- [자바 스타일 가이드](https://google.github.io/styleguide/javaguide.html)
- [클린 코드 체크 리스트 ](https://github.com/woowacourse/woowacourse-docs/blob/main/cleancode/pr_checklist.md)
- [커밋 메세지 컨벤션](https://gist.github.com/stephenparish/9941e89d80e2bc58a153)

- InteliJ kotlin formatting을 활용하여 프로그래밍 하였습니다.