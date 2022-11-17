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
        val line = Console.readLine()
        Exception.validateNumber(line)
        Exception.validateSizeRange(line.toInt())
        return line.toInt()
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        val line = Console.readLine()
        Exception.validateDirectionRange(line)
        return line
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        val line = Console.readLine()
        Exception.validateRestartRange(line)
        return line
    }
}
