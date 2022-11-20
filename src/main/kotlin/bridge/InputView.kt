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
        OutputView.errorType = OutputView.Error.BRIDGE_INPUT_ERROR
        if (!inputInvalidCheck.checkBridgeSize(inputTrim)) return -1
        val bridgeSize = inputConverter.convertBridgeSize(inputTrim)
        if (bridgeSize < BRIDGE_LOWER_INCLUSIVE || bridgeSize > BRIDGE_UPPER_INCLUSIVE) return -1
        OutputView.errorType = OutputView.Error.NON_ERROR
        return bridgeSize
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        return ""
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        return ""
    }

    companion object {
        const val BRIDGE_LOWER_INCLUSIVE = 3
        const val BRIDGE_UPPER_INCLUSIVE = 20
    }
}
