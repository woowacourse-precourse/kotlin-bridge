package bridge.view

import camp.nextstep.edu.missionutils.Console

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {
    fun readBridgeSize(): Int = try {
        readLineWithTrim().toInt()
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException(ERROR_NOT_NUMBER)
    }

    fun readMoving(): String {
        return readLineWithTrim()
    }

    fun readGameCommand(): String {
        return readLineWithTrim()
    }

    private fun readLineWithTrim() = Console.readLine().trim()

    companion object {
        private const val ERROR_NOT_NUMBER = "숫자가 아닙니다."
    }
}
