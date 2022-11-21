package bridge

import bridge.utils.Messages

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView {
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printMap() {

//        시작과 함께 제공되는 괄호
        print('[')

//        다리 정답 여부에 따라 제공되는 O X
        print('O')

        print('X')

//      다리 길이에 따라 제공되는 추가, 혹은 마무리 괄호
        print('|')

        print(']')

    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult() {
//        게임의 성공 실패에 따라서 제공되는 메세지
        print(Messages.GameSuccess)
        print(Messages.GameFail)

        print(Messages.GameLastResult)
//        게임 실행 횟수에 따라 제공되는 메세지
        print(Messages.GameTryTimes)
    }
}
