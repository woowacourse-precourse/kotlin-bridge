package bridge.view

import bridge.resources.*
import camp.nextstep.edu.missionutils.Console

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    fun readBridgeSize(): Int {
        while (true) {
            try {
                println(INPUT_BRIDGE_LENGTH)
                return inputInteger()
            } catch (illegalException: IllegalArgumentException) {
                println(illegalException.message)
            }
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        while (true) {
            try {
                println(INPUT_NEXT_MOVING_POSITION)
                return inputMoving()
            } catch (illegalException: IllegalArgumentException) {
                println(illegalException.message)
            }
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        while (true) {
            try {
                println(INPUT_RETRY_OR_QUIT)
                return inputRetry()
            } catch (illegalException: IllegalArgumentException) {
                println(illegalException.message)
            }
        }
    }

    private fun input(): String = Console.readLine()
    fun inputInteger() = input().getIntRangeOrError()
    fun inputMoving() = input().getMovingOrError()
    fun inputRetry() = input().getRetryOrError()
}
