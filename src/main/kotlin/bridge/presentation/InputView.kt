package bridge.presentation

import bridge.exception.BridgeException
import bridge.utils.BridgeErrorMessage.COMMAND_ERROR
import bridge.utils.BridgeErrorMessage.MOVING_ERROR
import bridge.utils.BridgeErrorMessage.SIZE_ERROR
import camp.nextstep.edu.missionutils.Console

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    fun readBridgeSize(): Int {
        return try {
            BridgeException(Console.readLine()).toSize()
        } catch (e: IllegalArgumentException) {
            println(SIZE_ERROR)
            println(RETRY_MESSAGE)
            readBridgeSize()
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        return try {
            BridgeException(Console.readLine()).toMoving()
        } catch (e: IllegalArgumentException) {
            println(MOVING_ERROR)
            println(RETRY_MESSAGE)
            readMoving()
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        return try {
            BridgeException(Console.readLine()).toGameCommand()
        } catch (e: IllegalArgumentException) {
            println(COMMAND_ERROR)
            println(RETRY_MESSAGE)
            readGameCommand()
        }
    }

    companion object {
        const val RETRY_MESSAGE = "다시 입력해주세요: "
    }
}
