package bridge.presentation

import bridge.exception.BridgeException
import bridge.utils.BridgeErrorMessage.COMMAND_ERROR
import bridge.utils.BridgeErrorMessage.MOVING_ERROR
import bridge.utils.BridgeErrorMessage.SIZE_ERROR
import kotlin.system.exitProcess

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    fun readBridgeSize(): Int {
        try {
            val inp = readLine()
            return BridgeException(inp).toSize()
        } catch (e: IllegalArgumentException) {
            println(SIZE_ERROR)
            exitProcess(0)
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        try {
            val inp = readLine()
            return BridgeException(inp).toMoving()
        } catch (e: IllegalArgumentException) {
            println(MOVING_ERROR)
            exitProcess(0)
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        try {
            val inp = readLine()
            return BridgeException(inp).toGameCommand()
        } catch (e: IllegalArgumentException) {
            println(COMMAND_ERROR)
            exitProcess(0)
        }
    }
}
