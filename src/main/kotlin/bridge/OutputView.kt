package bridge

import bridge.GameView.Companion.ERROR_MESSAGE_INPUT_BRIDGE_LENGTH
import bridge.GameView.Companion.ERROR_MESSAGE_PREFIX
import bridge.GameView.Companion.ERROR_UNKNOWN

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView {
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printMap() {}

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult() {}


    companion object {
        fun printErrorMessage(e: Exception) {
            println(
                when (e) {
                    is NumberFormatException -> "$ERROR_MESSAGE_PREFIX $ERROR_MESSAGE_INPUT_BRIDGE_LENGTH"
                    else -> "$ERROR_MESSAGE_PREFIX $ERROR_UNKNOWN"
                }
            )
        }
    }
}
