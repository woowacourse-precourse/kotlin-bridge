package bridge.presentation

import bridge.exception.BridgeException
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
            println("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.")
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
            println("[ERROR] 다리 길이는 'U' 또는 'R'을 통해서만 움직일 수 있습니다.")
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
            println("[ERROR] 재시작을 위해선 'R' 또는 'Q'를 입력받아야합니다.")
            exitProcess(0)
        }
    }
}
