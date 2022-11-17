package bridge.view

import camp.nextstep.edu.missionutils.Console

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    fun readBridgeSize(): Int = try {
        readLineWithTrim().toInt()
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException(ERROR_NOT_NUMBER)
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        return readLineWithTrim()
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        return readLineWithTrim()
    }

    private fun readLineWithTrim() = Console.readLine().trim()

    companion object {
        private const val ERROR_NOT_NUMBER = "숫자가 아닙니다."
    }
}
