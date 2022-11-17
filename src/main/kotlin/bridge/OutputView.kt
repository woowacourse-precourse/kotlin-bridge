package bridge

import bridge.Constant.GAME_FAILED_MESSAGE
import bridge.Constant.GAME_OVER_MESSAGE
import bridge.Constant.GAME_START_MESSAGE
import bridge.Constant.GAME_SUCCESS_MESSAGE
import bridge.Constant.TOTAL_ATTEMPTS_MESSAGE

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView {
    fun printStart() {
        println(GAME_START_MESSAGE)
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printMap(upBridge: List<String>, downBridge: List<String>) {
        println(upBridge.toString().replace(",", " |").replace("[", "[ ").replace("]", " ]"))
        println(downBridge.toString().replace(",", " |").replace("[", "[ ").replace("]", " ]"))
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult() {
        println(GAME_OVER_MESSAGE)
    }

    fun printResultIsSuccess(isSuccess: Boolean, count: Int) {
        if (isSuccess) println(GAME_SUCCESS_MESSAGE) else println(GAME_FAILED_MESSAGE)
        print(TOTAL_ATTEMPTS_MESSAGE + count)
    }
}
