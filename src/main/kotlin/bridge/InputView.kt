package bridge

import camp.nextstep.edu.missionutils.Console

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    private fun input() = Console.readLine().trim()

    fun readBridgeSize(
        outputView: OutputView,
        inputInvalidCheck: InputInvalidCheck,
        inputConverter: InputConverter,
    ): Int {
        while (true) {
            outputView.bridgeLengthInputPleaseMessage()
            val inputTrim = input()
            kotlin.runCatching { inputInvalidCheck.checkBridgeSize(inputTrim, inputConverter) }
                .onSuccess { return inputConverter.convertBridgeSize(inputTrim) }
                .onFailure { println(it.message) }
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(outputView: OutputView, inputInvalidCheck: InputInvalidCheck): String {
        while (true) {
            outputView.moveInputPleaseMessage()
            val inputTrim = input()
            kotlin.runCatching { inputInvalidCheck.checkMoving(inputTrim) }
                .onSuccess { return inputTrim }
                .onFailure { println(it.message) }
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(outputView: OutputView, inputInvalidCheck: InputInvalidCheck): String {
        while (true) {
            outputView.retryInputPleaseMessage()
            val inputTrim = input()
            kotlin.runCatching { inputInvalidCheck.checkGameCommand(inputTrim) }
                .onSuccess { return inputTrim }
                .onFailure { println(it.message) }
        }
    }

    companion object {
        const val BRIDGE_LOWER_INCLUSIVE = 3
        const val BRIDGE_UPPER_INCLUSIVE = 20
    }
}
