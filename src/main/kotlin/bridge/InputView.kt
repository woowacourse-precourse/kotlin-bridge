package bridge

import camp.nextstep.edu.missionutils.Console

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    private fun input() = Console.readLine()

    fun readBridgeSize(inputInvalidCheck: InputInvalidCheck, inputConverter: InputConverter): Int {
        val inputTrim = input().trim()
        inputInvalidCheck.checkBridgeSize(inputTrim, inputConverter)
        return inputConverter.convertBridgeSize(inputTrim)
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(inputInvalidCheck: InputInvalidCheck): String {
        val inputTrim = input().trim()
        inputInvalidCheck.checkMoving(inputTrim)
        return inputTrim
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(inputInvalidCheck: InputInvalidCheck): String {
        val inputTrim = input().trim()
        inputInvalidCheck.checkGameCommand(inputTrim)
        return inputTrim
    }

    companion object {
        const val BRIDGE_LOWER_INCLUSIVE = 3
        const val BRIDGE_UPPER_INCLUSIVE = 20
    }
}
