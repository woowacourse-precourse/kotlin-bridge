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
        if (!inputInvalidCheck.checkBridgeSize(inputTrim)) throwError()
        val bridgeSize = inputConverter.convertBridgeSize(inputTrim)
        if (bridgeSize < BRIDGE_LOWER_INCLUSIVE || bridgeSize > BRIDGE_UPPER_INCLUSIVE) throwError()
        OutputView.errorType = OutputView.Error.NON_ERROR
        return bridgeSize
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(inputInvalidCheck: InputInvalidCheck): String {
        val inputTrim = input().trim()
        OutputView.errorType = OutputView.Error.MOVE_INPUT_ERROR
        if (!inputInvalidCheck.checkMoving(inputTrim)) throwError()
        OutputView.errorType = OutputView.Error.NON_ERROR
        return inputTrim
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(inputInvalidCheck: InputInvalidCheck): String {
        val inputTrim = input().trim()
        OutputView.errorType = OutputView.Error.RETRY_INPUT_ERROR
        if (!inputInvalidCheck.checkGameCommand(inputTrim)) throwError()
        OutputView.errorType = OutputView.Error.NON_ERROR
        return inputTrim
    }

    private fun throwError() {
        throw IllegalArgumentException()
    }

    companion object {
        const val BRIDGE_LOWER_INCLUSIVE = 3
        const val BRIDGE_UPPER_INCLUSIVE = 20
    }
}
