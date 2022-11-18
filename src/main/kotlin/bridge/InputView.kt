package bridge

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
            val line = Console.readLine()
            Exception.validateNumber(line)
            Exception.validateSizeRange(line.toInt())
            line.toInt()
        } catch (e: IllegalArgumentException) {
            readBridgeSize()
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        return try {
            val line = Console.readLine()
            Exception.validateDirectionRange(line)
            line
        } catch (e: IllegalArgumentException) {
            readMoving()
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        return try {
            val line = Console.readLine()
            Exception.validateRestartRange(line)
            line
        } catch (e: IllegalArgumentException) {
            readGameCommand()
        }
    }
}
