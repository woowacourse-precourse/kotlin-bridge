package bridge

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
            return BridgeException(inp).toBridgeSize()
        } catch (e: IllegalArgumentException) {
            println("[ERROR] bridge Size should be integer(3~20)")
            exitProcess(0)
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        try {
            val inp = readLine()
            return BridgeException(inp).toBridgeMoving()
        } catch (e: IllegalArgumentException) {
            println("[ERROR] bridge can move only 'U' or 'D'")
            exitProcess(0)
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        return ""
    }
}
