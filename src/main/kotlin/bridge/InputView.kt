package bridge

import Utils.Constants.TYPE_BRIDGE_SIZE
import Utils.Constants.TYPE_COMMAND
import Utils.Constants.TYPE_MOVING
import camp.nextstep.edu.missionutils.Console

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {
    private val rule = Rule()

    // 다리의 길이를 입력받는다.
    fun readBridgeSize(): Int {
        return getCorrectValue(TYPE_BRIDGE_SIZE).toInt()
    }

    fun readMoving(): String {
        return getCorrectValue(TYPE_MOVING)
    }

    fun readGameCommand(): String {
        return getCorrectValue(TYPE_COMMAND)
    }

    private fun getCorrectValue(type: String): String {
        var input = ""
        var isWrong = true
        do {
            input = Console.readLine()
            try {
                rule.checkValue(input, type)
                isWrong = false
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }

        } while (isWrong)

        return input
    }
}
